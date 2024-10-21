import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UseSession } from 'src/app/util/useSession';
import { environment } from 'src/environments/environment';
import { MemberRequest, MemberType } from '../domain/member_request';
import { MemberResponse } from '../domain/member_response';

@Injectable({
  providedIn: 'root',
})
export class MemberService {
  public useSession: UseSession;

  constructor(private http: HttpClient) {
    this.useSession = new UseSession();
  }

  listMember(scheduleId: string): Observable<MemberResponse> {
    const memberId: string = this.useSession.getUser().id;
    return this.http.get<MemberResponse>(
      `${environment.url}/members/${memberId}/schedule/${scheduleId}`
    );
  }

  list(scheduleId: string): Observable<MemberResponse[]> {
    return this.http.get<MemberResponse[]>(
      `${environment.url}/members/schedule/${scheduleId}`
    );
  }

  delete(memberId: string): Observable<any> {
    return this.http.delete<any>(`${environment.url}/members/${memberId}`);
  }

  save(member: MemberRequest): Observable<MemberResponse> {
    member.ownerId = this.useSession.getUser().id;
    return this.http.post<MemberResponse>(
      `${environment.url}/members/schedules`,
      member
    );
  }

  listSchedules(): Observable<MemberResponse[]> {
    const memberId: string = this.useSession.getUser().id;
    return this.http.get<MemberResponse[]>(
      `${environment.url}/members/${memberId}/schedule`
    );
  }

  accept(member: MemberResponse): Observable<MemberResponse> {
    let accept = {
      accept: member.accept == true ? false : true,
    };
    return this.http.put<MemberResponse>(
      `${environment.url}/members/${member.id}`,
      accept
    );
  }

  memberType(memberId: string, type: MemberType): Observable<MemberResponse> {
    let member = {
      memberType: type,
    };
    return this.http.put<MemberResponse>(
      `${environment.url}/members/${memberId}`,
      member
    );
  }
}
