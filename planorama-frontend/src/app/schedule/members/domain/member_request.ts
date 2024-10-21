export class MemberRequest {
  public ownerId!: string;
  public schedule: ScheduleMember = new ScheduleMember();
  public email!: string;
  public memberType: MemberType = MemberType.VIEWER;
}

export enum MemberType {
  EDITOR,
  VIEWER,
}

export class ScheduleMember {
  public id!: string;
  public name!: string;
}
