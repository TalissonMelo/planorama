import { Component, OnInit } from '@angular/core';
import label from 'src/assets/i18n/label';
import { LoaderService } from '../components/loader/loader.service';
import { NotificationService } from '../components/notification/notification.service';
import { UseSession } from '../util/useSession';
import { UserUpdateRequest } from './model/user_update_request';
import { ProfileService } from './service/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  public label = label;
  public user: UserUpdateRequest;
  public useSession: UseSession = new UseSession();

  constructor(
    private service: ProfileService,
    private loaderService: LoaderService,
    private notificationService: NotificationService
  ) {
    this.user = new UserUpdateRequest();
  }

  ngOnInit(): void {
    this.loaderService.show();
    this.service.user().subscribe((res) => {
      this.user = res;
      if (this.user == null) {
        this.user = new UserUpdateRequest();
        this.user.userId = this.useSession.getUser().id;
        this.user.email = this.useSession.getUser().email;
        this.user.nickname = this.useSession.getUser().nickname;
      }
      this.loaderService.hide();
    });
  }

  onSubmit() {
    if (this.isValid()) {
      this.loaderService.show();
      this.service.userUpdate(this.user).subscribe(
        (res) => {
          this.loaderService.hide();
          this.useSession.clear();
          this.notificationService.showSuccess('Data changed successfully!');
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError('Invalid data please try again.');
        }
      );
    }
  }

  isValid(): boolean {
    if (this.user.nickname != '') {
      return true;
    }
    this.notificationService.showError('Invalid user data, please try again.');
    return false;
  }
}
