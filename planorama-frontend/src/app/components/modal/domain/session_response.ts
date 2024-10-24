import { Captions } from './captions';

export class SessionResponse {
  public id!: string;
  public scheduleId!: string;
  public ownerId!: string;
  public title!: string;
  public startTime!: Date;
  public endTime!: Date;
  public description!: string;
  public caption!: Captions;
  public color!: Color;
}

export class Color {
  public primary: string;
  public secondary: string;

  constructor(primary: string, secondary: string) {
    this.primary = primary;
    this.secondary = secondary;
  }
}
