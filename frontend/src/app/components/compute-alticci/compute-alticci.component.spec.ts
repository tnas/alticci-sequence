import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComputeAlticciComponent } from './compute-alticci.component';

describe('ComputeAlticciComponent', () => {
  let component: ComputeAlticciComponent;
  let fixture: ComponentFixture<ComputeAlticciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComputeAlticciComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComputeAlticciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
