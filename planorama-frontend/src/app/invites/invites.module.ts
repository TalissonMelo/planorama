import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvitesRoutingModule } from './invites-routing.module';
import { InvitesComponent } from './invites.component';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [InvitesComponent],
  imports: [
    CommonModule,
    InvitesRoutingModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    TranslateModule,
  ],
})
export class InvitesModule {}
