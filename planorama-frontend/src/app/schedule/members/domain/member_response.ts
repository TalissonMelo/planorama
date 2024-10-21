import { MemberType, ScheduleMember } from './member_request';

export class MemberResponse {
  public id!: string;
  public ownerId!: string;
  public user!: UserMember;
  public schedule!: ScheduleMember;
  public email!: string;
  public memberType: MemberType = MemberType.VIEWER;
  public active!: boolean;
  public accept!: boolean;
}

export class UserMember {
  public id!: string;
  public name!: string;
  public email!: string;
}
