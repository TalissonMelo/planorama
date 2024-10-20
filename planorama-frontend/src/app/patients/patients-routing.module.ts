import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { AnamneseComponent } from './anamnese/anamnese.component';
import { GuardRotasGuard } from '../guard-rotas.guard';

const routes: Routes = [
  { path: '', component: PatientListComponent, canActivate: [GuardRotasGuard] },
  {
    path: 'new',
    component: PatientFormComponent,
    canActivate: [GuardRotasGuard],
  },
  {
    path: 'edit/:id',
    component: PatientFormComponent,
    canActivate: [GuardRotasGuard],
  },
  {
    path: ':id/anamnese',
    component: AnamneseComponent,
    canActivate: [GuardRotasGuard],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PatientsRoutingModule {}
