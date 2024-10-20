import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientsRoutingModule } from './patients-routing.module';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { AnamneseComponent } from './anamnese/anamnese.component';
import { MatIconModule } from '@angular/material/icon';
import { TranslateModule } from '@ngx-translate/core';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [PatientListComponent, PatientFormComponent, AnamneseComponent],
  imports: [
    CommonModule,
    PatientsRoutingModule,
    MatIconModule,
    TranslateModule,
    FormsModule,
  ],
})
export class PatientsModule {}
