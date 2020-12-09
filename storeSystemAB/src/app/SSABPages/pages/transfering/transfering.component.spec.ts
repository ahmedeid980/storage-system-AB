import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferingComponent } from './transfering.component';

describe('TransferingComponent', () => {
  let component: TransferingComponent;
  let fixture: ComponentFixture<TransferingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransferingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransferingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
