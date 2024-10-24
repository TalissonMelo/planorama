import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UseSession } from 'src/app/util/useSession';
import { environment } from 'src/environments/environment';
import { UserUpdateRequest } from '../model/user_update_request';
@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  public useSession: UseSession;

  constructor(private http: HttpClient) {
    this.useSession = new UseSession();
  }

  userUpdate(user: UserUpdateRequest): Observable<void> {
    return this.http.put<void>(
      `${environment.url}/users/${this.useSession.getUser().id}`,
      user
    );
  }

  user(): Observable<UserUpdateRequest> {
    return this.http.get<UserUpdateRequest>(
      `${environment.url}/users/${this.useSession.getUser().id}`
    );
  }
}
