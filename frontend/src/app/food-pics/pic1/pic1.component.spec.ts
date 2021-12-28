import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic1Component } from './pic1.component';

describe('Pic1Component', () => {
  let component: Pic1Component;
  let fixture: ComponentFixture<Pic1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
