import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AlticciService } from './alticci.service';

@Component({
  selector: 'app-compute-alticci',
  templateUrl: './compute-alticci.component.html',
  styleUrls: ['./compute-alticci.component.css']
})
export class ComputeAlticciComponent {

  alticciForm!: FormGroup;
  computedElement!: number;

  constructor(
    private service: AlticciService,
    private formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this.alticciForm = this.formBuilder.group({
      element: ['']
  });
  }

  computeElement() {

    if (this.alticciForm.valid) {
      console.log(this.alticciForm.value);
      this.service.computeElement(this.alticciForm.value['element']).subscribe(
        (alticciNumber: number) => { this.computedElement = alticciNumber});
    }
  }
}
