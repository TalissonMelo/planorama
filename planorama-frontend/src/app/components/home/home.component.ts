import { Component, OnInit } from '@angular/core';
import { ScheduleService } from 'src/app/schedule/schedule-name/service/schedule.service';
import { UseSession } from 'src/app/util/useSession';
import { LoaderService } from '../loader/loader.service';
import { Home } from './domain/home';
import { HomeFreeTimes } from './domain/home_free_times';
import label from 'src/assets/i18n/label';
import { MatDialog } from '@angular/material/dialog';
import { AddSessionModalComponent } from 'src/app/components/add-session-modal/add-session-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  public label = label;
  public useSession: UseSession;
  public busyHours: Home[] = [];
  public selectedDate!: string;
  public vacantTimes: HomeFreeTimes[] = [];
  public selectedDuration: number = 30;
  public durations: any[] = [
    { value: 30, label: '30 min' },
    { value: 60, label: '1 hr' },
    { value: 90, label: '1 hr 30 min' },
    { value: 120, label: '2 hr' },
  ];

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private service: ScheduleService,
    private loaderService: LoaderService
  ) {
    this.useSession = new UseSession();
  }

  ngOnInit(): void {
    this.initialDate();
    this.selectDay();
  }

  public initialDate(): void {
    const today = new Date();
    const year = today.getFullYear();
    const month = ('0' + (today.getMonth() + 1)).slice(-2);
    const day = ('0' + today.getDate()).slice(-2);
    this.selectedDate = `${year}-${month}-${day}`;
  }

  onDateChange(event: any) {
    this.selectedDate = event.value.toISOString().split('T')[0];
    this.selectDay();
  }

  selectDay(): void {
    //this.loaderService.show();
    // this.service.listed(this.selectedDate).subscribe((res) => {
    //   this.busyHours = res;
    //   this.listVacanTimes();
    // });
  }

  listVacanTimes(): void {
    // this.service
    //   .listedFree(this.selectedDate, this.selectedDuration)
    //   .subscribe((response) => {
    //     this.vacantTimes = response;
    //     this.loaderService.hide();
    //   });
  }

  onDurationChange(event: any) {
    this.listVacanTimes();
  }

  openAddModal(time: any) {
    const dialogRef = this.dialog.open(AddSessionModalComponent, {
      data: { time: time },
    });
  }

  openVideo(session: any): void {
    const url = this.router.serializeUrl(this.router.createUrlTree(['/video']));
    window.open(url, '_blank');
  }
}
