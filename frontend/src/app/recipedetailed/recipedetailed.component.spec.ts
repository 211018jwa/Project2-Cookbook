import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipedetailedComponent } from './recipedetailed.component';

describe('RecipedetailedComponent', () => {
  let component: RecipedetailedComponent;
  let fixture: ComponentFixture<RecipedetailedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipedetailedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipedetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
