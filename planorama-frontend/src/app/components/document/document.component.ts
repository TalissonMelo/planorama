import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
})
export class DocumentComponent implements OnInit {
  @Input() id: string = '';
  @Input() placeholder: string = '';
  @Input() changeDocument: string = '';
  @Output() documentChange = new EventEmitter<string>();

  documentType: 'CPF' | 'CNPJ' = 'CPF';

  mask: string = '000.000.000-00';
  specialCharacters: string[] = ['.', '-'];

  ngOnInit(): void {
    this.updateMask();
  }

  onDocumentChange(value: string) {
    this.changeDocument = value;
    this.documentChange.emit(this.changeDocument);
  }

  onDocumentTypeChange(type: any) {
    this.documentType = type.target.value;
    this.updateMask();
  }

  updateMask() {
    if (this.documentType === 'CPF') {
      this.mask = '000.000.000-00';
      this.specialCharacters = ['.', '-'];
      this.placeholder = '000.000.000-00';
    } else {
      this.mask = '00.000.000/0000-00';
      this.specialCharacters = ['.', '/', '-'];
      this.placeholder = '00.000.000/0000-00';
    }
  }
}
