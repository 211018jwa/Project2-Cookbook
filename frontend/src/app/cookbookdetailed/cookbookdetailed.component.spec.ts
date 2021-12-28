import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CookbookdetailedComponent } from './cookbookdetailed.component';

describe('CookbookdetailedComponent', () => {
  let component: CookbookdetailedComponent;
  let fixture: ComponentFixture<CookbookdetailedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CookbookdetailedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CookbookdetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
