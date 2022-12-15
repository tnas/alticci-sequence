import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlticciService } from './alticci.service';

@Component({
  selector: 'app-compute-alticci',
  templateUrl: './compute-alticci.component.html',
  styleUrls: ['./compute-alticci.component.css']
})
export class ComputeAlticciComponent {

  alticciForm!: FormGroup;
  computedElement!: number;
  showResult: boolean = false;
  backendError: boolean = false;

  constructor(
    private service: AlticciService,
    private formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this.alticciForm = this.formBuilder.group({
      element: ['', Validators.compose([
        Validators.required, Validators.pattern('[0-9]+'),
        Validators.min(0), Validators.max(1000)
      ])]
  });
  }

  computeElement(): void {

    if (this.alticciForm.valid) {

      this.service.computeElement(this.alticciForm.value['element']).subscribe({
        next: (alticciNumber: number) => {
          this.computedElement = alticciNumber;
          this.backendError = false;
          this.showResult = true;

        },
        error: (e) => {
          console.log(e);
          this.backendError = true;
        }
      });
    }
  }

  clearComputedElement(): void {
    this.showResult = false;
    this.backendError = false;
  }
}
