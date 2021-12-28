import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic3Component } from './pic3.component';

describe('Pic3Component', () => {
  let component: Pic3Component;
  let fixture: ComponentFixture<Pic3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
