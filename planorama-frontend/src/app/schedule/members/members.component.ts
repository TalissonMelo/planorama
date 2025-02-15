import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LoaderService } from 'src/app/components/loader/loader.service';
import { NotificationService } from 'src/app/components/notification/notification.service';
import { UseSession } from 'src/app/util/useSession';
import label from 'src/assets/i18n/label';
import { ScheduleResponse } from '../schedule-name/domain/schedule_response';
import { MemberRequest, MemberType } from './domain/member_request';
import { MemberResponse } from './domain/member_response';
import { MemberService } from './service/member.service';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
})
export class MembersComponent implements OnInit {
  public members: MemberResponse[] = [];
  public schedule: ScheduleResponse;
  public useSession: UseSession;
  public member: MemberRequest;
  public label = label;
  public memberType = MemberType;

  constructor(
    private translate: TranslateService,
    private service: MemberService,
    private loaderService: LoaderService,
    private notificationService: NotificationService
  ) {
    this.member = new MemberRequest();
    this.useSession = new UseSession();
    this.schedule = this.useSession.getScheduleId();
    this.member.schedule.id = this.schedule.id;
    this.member.schedule.name = this.schedule.name;
  }

  ngOnInit(): void {
    this.listMember();
    this.listAllMembers();
  }

  listMember(): void {
    this.loaderService.show();
    this.service.listMember(this.schedule.id).subscribe(
      (res) => {
        this.members.push(res);
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }

  listAllMembers(): void {
    this.loaderService.show();
    this.service.list(this.schedule.id).subscribe(
      (res) => {
        this.members = res;
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }

  save(): void {
    if (this.isValidMember()) {
      this.loaderService.show();
      this.service.save(this.member).subscribe(
        (res) => {
          this.member = new MemberRequest();
          this.members.push(res);
          this.loaderService.hide();
          this.notificationService.showSuccess('Member added successfully!');
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Member not registered please try again.'
          );
        }
      );
    }
  }

  isValidMember(): boolean {
    if (this.member.email != null && this.member.memberType != null) {
      return true;
    }
    this.notificationService.showError('Fill in all fields and try again.');
    return false;
  }

  deletarMembro(member: MemberResponse): void {
    if (confirm('Do you want to delete the member: ' + member.user.name)) {
      this.loaderService.show();
      this.service.delete(member.id).subscribe(
        (res) => {
          const index = this.members.indexOf(member);
          this.members.splice(index, 1);
          this.loaderService.hide();
          this.notificationService.showSuccess('Member deleted successfully!');
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Member not deleted please try again.'
          );
        }
      );
    }
  }

  onMemberTypeChange(newType: any, member: any) {
    this.loaderService.show();
    this.service.memberType(member.id, newType.target.value).subscribe(
      (res) => {
        member.memberType = newType.target.value;
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }
}
