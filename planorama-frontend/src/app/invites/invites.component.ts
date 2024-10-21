import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { MemberService } from '../schedule/members/service/member.service';
import { LoaderService } from '../components/loader/loader.service';
import { NotificationService } from '../components/notification/notification.service';
import label from 'src/assets/i18n/label';
import { MemberResponse } from '../schedule/members/domain/member_response';

@Component({
  selector: 'app-invites',
  templateUrl: './invites.component.html',
})
export class InvitesComponent implements OnInit {
  public members: MemberResponse[] = [];
  public label = label;

  constructor(
    private translate: TranslateService,
    private service: MemberService,
    private loaderService: LoaderService,
    private notificationService: NotificationService
  ) {}

  ngOnInit(): void {
    this.listAllMembers();
  }

  listAllMembers(): void {
    this.loaderService.show();
    this.service.listSchedules().subscribe(
      (res) => {
        this.members = res;
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }

  accept(members: MemberResponse): void {
    this.loaderService.show();
    this.service.accept(members).subscribe(
      (res) => {
        members.accept = members.accept == true ? false : true;
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }
}
