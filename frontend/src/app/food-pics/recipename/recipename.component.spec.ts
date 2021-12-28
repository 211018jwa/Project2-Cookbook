import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipenameComponent } from './recipename.component';

describe('RecipenameComponent', () => {
  let component: RecipenameComponent;
  let fixture: ComponentFixture<RecipenameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipenameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipenameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
