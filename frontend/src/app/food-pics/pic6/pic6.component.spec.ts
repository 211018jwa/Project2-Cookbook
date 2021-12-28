import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pic6Component } from './pic6.component';

describe('Pic6Component', () => {
  let component: Pic6Component;
  let fixture: ComponentFixture<Pic6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pic6Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pic6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
