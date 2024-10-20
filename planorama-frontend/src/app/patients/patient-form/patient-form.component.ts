import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../patient.service';
import label from 'src/assets/i18n/label';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
})
export class PatientFormComponent implements OnInit {
  public label = label;
  paciente: any = {};
  editing: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private translate: TranslateService,
    private patientService: PatientService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.editing = true;
      this.patientService.getPatient(+id).subscribe((data) => {
        this.paciente = data;
      });
    }
  }

  savePatient(): void {
    if (this.editing) {
      this.patientService
        .updatePatient(this.paciente.id, this.paciente)
        .subscribe(() => {
          this.router.navigate(['/patients']);
        });
    } else {
      this.patientService.createPatient(this.paciente).subscribe(() => {
        this.router.navigate(['/patients']);
      });
    }
  }
}
