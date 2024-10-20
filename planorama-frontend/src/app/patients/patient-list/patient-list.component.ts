import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { TranslateService } from '@ngx-translate/core';
import label from 'src/assets/i18n/label';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
})
export class PatientListComponent implements OnInit {
  public label = label;
  patients: any[] = [];

  constructor(
    private patientService: PatientService,
    private translate: TranslateService
  ) {}

  ngOnInit(): void {
    this.patients = [
      {
        id: 1,
        nome: 'João Silva',
        email: 'joao.silva@email.com',
        telefone: '(11) 99999-1234',
      },
      {
        id: 2,
        nome: 'Ana Costa',
        email: 'ana.costa@email.com',
        telefone: '(21) 98765-4321',
      },
      {
        id: 3,
        nome: 'Carlos Pereira',
        email: 'carlos.pereira@email.com',
        telefone: '(31) 91234-5678',
      },
    ];
  }

  deletePatient(id: number): void {
    this.patientService.deletePatient(id).subscribe(() => {
      this.patients = this.patients.filter((p) => p.id !== id);
    });
  }
}
