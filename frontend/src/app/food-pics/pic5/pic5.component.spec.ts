import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic5Component } from './pic5.component';

describe('Pic5Component', () => {
  let component: Pic5Component;
  let fixture: ComponentFixture<Pic5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
