import { Component, LOCALE_ID, OnDestroy, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { CalendarView } from 'angular-calendar';
import { Subject, Subscription } from 'rxjs';
import label from 'src/assets/i18n/label';
import { ChatComponent } from '../chat/chat.component';
import { LoaderService } from '../components/loader/loader.service';
import { Captions } from '../components/modal/domain/captions';
import { ModalComponent } from '../components/modal/modal.component';
import { SessionService } from '../components/modal/service/session.service';
import { NotificationEmitter } from '../components/notification/notification_emitter';
import { UseSession } from '../util/useSession';
import { MemberResponse } from './members/domain/member_response';
import { MemberService } from './members/service/member.service';
import { ScheduleResponse } from './schedule-name/domain/schedule_response';

export function localeFactory(translate: TranslateService) {
  return translate.getDefaultLang() === 'pt'
    ? 'pt-BR'
    : translate.getDefaultLang();
}

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css'],
  providers: [
    { provide: LOCALE_ID, useFactory: localeFactory, deps: [TranslateService] },
  ],
})
export class ScheduleComponent implements OnInit, OnDestroy {
  label = label;
  notificationSubscription!: Subscription;
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;
  viewDate: Date = new Date();
  events: any[] = [];

  public start!: number;
  public finish!: number;
  public useSession: UseSession;
  public schedule!: ScheduleResponse;
  public memberSchedule!: MemberResponse;
  public captions: Captions[] = [];

  refresh: Subject<void> = new Subject<void>();
  activeDayIsOpen: boolean = true;

  constructor(
    private router: Router,
    private notificationService: NotificationEmitter,
    private translate: TranslateService,
    private sessionService: SessionService,
    private loaderService: LoaderService,
    private memberService: MemberService,
    public dialog: MatDialog
  ) {
    this.useSession = new UseSession();
    this.schedule = this.useSession.getScheduleId();
  }
  ngOnInit(): void {
    this.listInit();
    this.notificationSubscription =
      this.notificationService.notificationEmitter.subscribe((message) => {
        this.listInit();
      });
  }

  get defaultLang() {
    return this.translate.getDefaultLang();
  }

  listInit(): void {
    this.schedule = this.useSession.getScheduleId();
    const date: Date = new Date();
    this.listSessions(date.getMonth() + 1, date.getFullYear());
    this.start = this.useSession.toNumber(this.schedule.startTime);
    this.finish = this.useSession.toNumberAddHour(this.schedule.endTime);
  }

  listMember(): void {
    this.loaderService.show();
    this.memberService.listMember(this.schedule.id).subscribe((res) => {
      this.memberSchedule = res;
      this.loaderService.hide();
    });
  }

  listSessions(month: number, year: number): void {
    this.loaderService.show();
    this.sessionService.sessions(this.schedule.id, month, year).subscribe(
      (res) => {
        this.listMember();
        this.events = res;
        this.captions = res.map((r) => r.caption);
        this.loaderService.hide();
      },
      (error) => {
        this.loaderService.hide();
      }
    );
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  closeOpenMonthViewDay() {
    this.loaderService.show();
    this.sessionService
      .sessions(
        this.schedule.id,
        this.viewDate.getMonth() + 1,
        this.viewDate.getFullYear()
      )
      .subscribe(
        (res) => {
          this.events = res;
          this.activeDayIsOpen = false;
          this.loaderService.hide();
        },
        (error) => {
          this.loaderService.hide();
        }
      );
  }

  openModal(day: { date: Date }): void {
    if (this.memberSchedule.memberType.toString() != 'VIEWER') {
      this.useSession.setDate(day);
      this.useSession.setScheduleId(this.schedule);
      this.dialog.open(ModalComponent);
    } else {
      this.viewDate = day.date;
      this.view = CalendarView.Day;
    }
  }

  onEventClicked(event: any): void {
    this.useSession.setSession(event.event);
    this.dialog.open(ChatComponent, {
      width: '400px',
      height: '100vh',
      position: { right: '0px', top: '0px' },
      data: { event: event.event },
      panelClass: 'custom-modal-class',
    });
  }

  ngOnDestroy(): void {
    if (this.notificationSubscription) {
      this.notificationSubscription.unsubscribe();
    }
  }
}
