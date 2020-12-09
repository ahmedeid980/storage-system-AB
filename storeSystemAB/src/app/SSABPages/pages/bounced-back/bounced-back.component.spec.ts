import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BouncedBackComponent } from './bounced-back.component';

describe('BouncedBackComponent', () => {
  let component: BouncedBackComponent;
  let fixture: ComponentFixture<BouncedBackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BouncedBackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BouncedBackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
