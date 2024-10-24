import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { format } from 'date-fns';
import { map, Observable } from 'rxjs';
import { UseSession } from 'src/app/util/useSession';
import { environment } from 'src/environments/environment';
import { SessionRequest } from '../domain/session_request';
import { Color, SessionResponse } from '../domain/session_response';
import { SessionUpdate } from '../domain/session_update';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  public useSession: UseSession;

  constructor(private http: HttpClient) {
    this.useSession = new UseSession();
  }

  sessions(
    scheduleId: string,
    month: number,
    year: number
  ): Observable<SessionResponse[]> {
    const headers = new HttpHeaders({
      timezone: this.useSession.getSettings().timeZone,
    });
    const params = new HttpParams().set('year', year).set('month', month);
    return this.http
      .get<SessionResponse[]>(
        `${environment.url}/sessions/schedule/${scheduleId}`,
        {
          headers,
          params,
        }
      )
      .pipe(
        map((sessions) =>
          sessions.map((session) => ({
            ...session,
            start: new Date(session.startTime),
            end: new Date(session.endTime),
            color: new Color(session.caption.color, session.caption.color),
          }))
        )
      );
  }

  listSessions(scheduleId: string, date: Date): Observable<SessionResponse[]> {
    const headers = new HttpHeaders({
      timezone: this.useSession.getSettings().timeZone,
    });
    const formattedDate = format(date, 'yyyy-MM-dd');
    const params = new HttpParams().set('date', formattedDate);
    return this.http.get<SessionResponse[]>(
      `${environment.url}/sessions/schedules/${scheduleId}`,
      { headers, params }
    );
  }

  edit(sessionId: string, session: SessionUpdate): Observable<void> {
    return this.http.put<void>(
      `${environment.url}/sessions/${sessionId}`,
      session
    );
  }

  delete(sessionId: string): Observable<any> {
    return this.http.delete<any>(`${environment.url}/sessions/${sessionId}`);
  }

  save(session: SessionRequest): Observable<void> {
    const headers = new HttpHeaders({
      timezone: this.useSession.getSettings().timeZone,
    });
    const userId: string = this.useSession.getUser().id;

    session.startTime = `${session.startDate}T${session.startTime}`;
    session.endTime = `${session.endDate}T${session.endTime}`;

    return this.http.post<void>(
      `${environment.url}/sessions/users/${userId}`,
      session,
      { headers }
    );
  }
}
