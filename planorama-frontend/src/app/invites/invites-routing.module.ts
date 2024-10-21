import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvitesComponent } from './invites.component';
import { GuardRotasGuard } from '../guard-rotas.guard';

const routes: Routes = [
  { path: '', component: InvitesComponent, canActivate: [GuardRotasGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InvitesRoutingModule {}
