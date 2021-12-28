import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipesummaryComponent } from './recipesummary.component';

describe('RecipesummaryComponent', () => {
  let component: RecipesummaryComponent;
  let fixture: ComponentFixture<RecipesummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipesummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipesummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
