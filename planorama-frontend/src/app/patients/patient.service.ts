import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  private apiUrl = 'http://localhost:8080/pacientes'; // URL do backend

  constructor(private http: HttpClient) {}

  getPatients(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getPatient(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  createPatient(patient: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, patient);
  }

  updatePatient(id: number, patient: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, patient);
  }

  deletePatient(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getAnamnese(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/${id}/anamnese`);
  }

  saveAnamnese(id: number, anamnese: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/${id}/anamnese`, anamnese);
  }
}
