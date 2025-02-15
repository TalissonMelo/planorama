import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfigureComponent } from './configure/configure.component';
import { GuardRotasGuard } from '../guard-rotas.guard';

const routes: Routes = [
  { path: '', component: ConfigureComponent, canActivate: [GuardRotasGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigureRoutingModule {}
