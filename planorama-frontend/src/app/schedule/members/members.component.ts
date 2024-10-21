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
  public memberSchedule!: MemberResponse;
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
        this.memberSchedule = res;
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
          this.notificationService.showSuccess(
            'Membro adicionado com sucesso!'
          );
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Membro não cadastrado por favor tente novamente.'
          );
        }
      );
    }
  }

  isValidMember(): boolean {
    if (this.member.email != null && this.member.memberType != null) {
      return true;
    }
    this.notificationService.showError(
      'Preencha todos os campos e tente novamente.'
    );
    return false;
  }

  deletarMembro(member: MemberResponse): void {
    if (confirm('Deseja deletar o membro: ' + member.user.name)) {
      this.loaderService.show();
      this.service.delete(member.id).subscribe(
        (res) => {
          const index = this.members.indexOf(member);
          this.members.splice(index, 1);
          this.loaderService.hide();
          this.notificationService.showSuccess('Membro deletada com sucesso!');
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Membro não deletada por favor tente novamente.'
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
