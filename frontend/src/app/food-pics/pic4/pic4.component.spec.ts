import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic4Component } from './pic4.component';

describe('Pic4Component', () => {
  let component: Pic4Component;
  let fixture: ComponentFixture<Pic4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
