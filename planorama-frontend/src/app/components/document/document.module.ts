import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DocumentComponent } from './document.component';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';
import { TranslateModule } from '@ngx-translate/core';

@NgModule({
  declarations: [DocumentComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMaskDirective,
    NgxMaskPipe,
    TranslateModule,
  ],
  exports: [DocumentComponent],
  providers: [provideNgxMask()],
})
export class DocumentModule {}
