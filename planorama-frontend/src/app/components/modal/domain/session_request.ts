import { Captions } from './captions';

export class SessionRequest {
  public scheduleId!: string;
  public caption: Captions = new Captions();
  public patient!: any;
  public title!: string;
  public startTime!: string;
  public endTime!: string;
  public description!: string;
  public daysOfWeeks: DayOfWeek[] = [];
  public startDate!: Date;
  public endDate!: Date;
}

enum DayOfWeek {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY,
}
