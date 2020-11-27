import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterParComponent } from './footer-par.component';

describe('FooterParComponent', () => {
  let component: FooterParComponent;
  let fixture: ComponentFixture<FooterParComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FooterParComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterParComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
