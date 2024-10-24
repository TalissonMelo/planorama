import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { TranslateService } from '@ngx-translate/core';
import { LegendResponse } from 'src/app/legend/domain/legend_response';
import { LegendService } from 'src/app/legend/service/legend.service';
import { MemberResponse } from 'src/app/schedule/members/domain/member_response';
import { MemberService } from 'src/app/schedule/members/service/member.service';
import { ScheduleResponse } from 'src/app/schedule/schedule-name/domain/schedule_response';
import { UseSession } from 'src/app/util/useSession';
import label from 'src/assets/i18n/label';
import { LoaderService } from '../loader/loader.service';
import { NotificationService } from '../notification/notification.service';
import { NotificationEmitter } from '../notification/notification_emitter';
import { SessionRequest } from './domain/session_request';
import { SessionResponse } from './domain/session_response';
import { SessionUpdate } from './domain/session_update';
import { SessionService } from './service/session.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent implements OnInit {
  public date: Date;
  public label = label;
  public dropdownOpen = false;
  public useSession: UseSession;
  public selectedDays: any[] = [];
  public schedule: ScheduleResponse;
  public sessionIdEdit: string = '';
  public legends: LegendResponse[] = [];
  public events: SessionResponse[] = [];
  public sessionRequest: SessionRequest;
  public memberSchedule!: MemberResponse;
  public isCreator: boolean = false;

  public daysOfWeeks =
    this.translate.getDefaultLang() === 'en'
      ? [
          { label: 'Monday', value: 'MONDAY' },
          { label: 'Tuesday', value: 'TUESDAY' },
          { label: 'Wednesday', value: 'WEDNESDAY' },
          { label: 'Thursday', value: 'THURSDAY' },
          { label: 'Friday', value: 'FRIDAY' },
          { label: 'Saturday', value: 'SATURDAY' },
          { label: 'Sunday', value: 'SUNDAY' },
        ]
      : [
          { label: 'Segunda-feira', value: 'MONDAY' },
          { label: 'Terça-feira', value: 'TUESDAY' },
          { label: 'Quarta-feira', value: 'WEDNESDAY' },
          { label: 'Quinta-feira', value: 'THURSDAY' },
          { label: 'Sexta-feira', value: 'FRIDAY' },
          { label: 'Sábado', value: 'SATURDAY' },
          { label: 'Domingo', value: 'SUNDAY' },
        ];

  constructor(
    private notificationService: NotificationService,
    private notificationEmitter: NotificationEmitter,
    private loaderService: LoaderService,
    private dialogRef: MatDialogRef<ModalComponent>,
    private memberService: MemberService,
    private legendService: LegendService,
    private sessionService: SessionService,
    public translate: TranslateService
  ) {
    this.sessionRequest = new SessionRequest();
    this.useSession = new UseSession();
    this.date = this.useSession.getDate().date;
    this.schedule = this.useSession.getScheduleId();
    this.isCreator = this.schedule.ownerId === this.useSession.getUser().id;
  }

  ngOnInit(): void {
    this.listMember();
    this.listLegends();
    this.listSessions();
  }

  listMember(): void {
    this.loaderService.show();
    this.memberService.listMember(this.schedule.id).subscribe((res) => {
      this.memberSchedule = res;
      this.loaderService.hide();
    });
  }

  listLegends(): void {
    this.loaderService.show();
    this.legendService.legends().subscribe((res) => {
      this.legends = res;
      this.loaderService.hide();
    });
  }

  listSessions(): void {
    this.loaderService.show();
    this.sessionService
      .listSessions(this.schedule.id, this.date)
      .subscribe((res) => {
        this.events = res;
        this.loaderService.hide();
      });
  }

  close() {
    this.notificationEmitter.emitNotification('');
    this.dialogRef.close();
  }

  addEvent(): void {
    this.sessionRequest.daysOfWeeks = this.selectedDays;
    this.sessionRequest.scheduleId = this.schedule.id;
    if (this.isValidSession()) {
      this.loaderService.show();
      this.sessionService.save(this.sessionRequest).subscribe(
        (res) => {
          this.ngOnInit();
          this.loaderService.hide();
          this.sessionRequest = new SessionRequest();
          this.notificationService.showSuccess(
            'Appointment registered successfully!'
          );
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Invalid booking, please try again.'
          );
        }
      );
    }
  }

  isValidSession(): boolean {
    if (this.sessionRequest.endTime <= this.sessionRequest.startTime) {
      this.notificationService.showError(
        'The end date must be greater than the start date.'
      );
      return false;
    }

    if (!this.sessionRequest.title) {
      this.notificationService.showError('The title cannot be null.');
      return false;
    }

    if (!this.sessionRequest.caption) {
      this.notificationService.showError('The legend cannot be null.');
      return false;
    }

    return true;
  }

  deleted(eventToDelete: SessionResponse) {
    if (confirm('Do you want to delete the schedule: ' + eventToDelete.title)) {
      this.loaderService.show();
      this.sessionService.delete(eventToDelete.id).subscribe(
        (res) => {
          const index = this.events.indexOf(eventToDelete);
          this.events.splice(index, 1);
          this.loaderService.hide();
          this.notificationService.showSuccess(
            'Appointment deleted successfully!'
          );
        },
        (error) => {
          this.loaderService.hide();
          this.notificationService.showError(
            'Schedule not deleted, please try again.'
          );
        }
      );
    }
  }

  onDayChange(event: any) {
    const dayValue = event.target.value;
    if (event.target.checked) {
      this.selectedDays.push(dayValue);
    } else {
      this.selectedDays = this.selectedDays.filter((day) => day !== dayValue);
    }
  }

  edit(session: SessionResponse): void {
    this.sessionIdEdit = this.sessionIdEdit == '' ? session.id : '';
  }

  editDescription(event: any) {
    this.loaderService.show();
    let uploadSession: SessionUpdate = new SessionUpdate();
    uploadSession.description = event.description;
    this.sessionService.edit(event.id, uploadSession).subscribe(
      (res) => {
        this.sessionIdEdit = '';
        this.loaderService.hide();
        this.notificationService.showSuccess('Schedule updated successfully!');
      },
      (error) => {
        this.loaderService.hide();
        this.notificationService.showError(
          'Schedule not updated, please try again.'
        );
      }
    );
  }

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

  selectLegend(legend: any) {
    this.sessionRequest.caption = legend;
    this.dropdownOpen = true;
  }

  getSelectedLegendDescription() {
    const selected = this.legends.find(
      (legend) => legend.id === this.sessionRequest.caption.id
    );
    return selected
      ? selected.description
      : this.translate.getDefaultLang() === 'en'
      ? 'Select a legend'
      : 'Selecione uma legenda';
  }

  getSelectedLegendColor() {
    const selected = this.legends.find(
      (legend) => legend.id === this.sessionRequest.caption.id
    );
    return selected ? selected.color : 'transparent';
  }
}
