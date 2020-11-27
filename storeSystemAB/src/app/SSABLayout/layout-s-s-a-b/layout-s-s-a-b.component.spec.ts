import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutSSABComponent } from './layout-s-s-a-b.component';

describe('LayoutSSABComponent', () => {
  let component: LayoutSSABComponent;
  let fixture: ComponentFixture<LayoutSSABComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutSSABComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LayoutSSABComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
