import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic2Component } from './pic2.component';

describe('Pic2Component', () => {
  let component: Pic2Component;
  let fixture: ComponentFixture<Pic2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
