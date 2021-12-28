import { Component, Input, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../Recipe';
import { reduce } from 'rxjs';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-random-recipe',
  templateUrl: './random-recipe.component.html',
  styleUrls: ['./random-recipe.component.css']
})
export class RandomRecipeComponent implements OnInit {


  ingredients : Array<string> = new Array<string>(); 

  recipeToBeDisplayed: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""

  };

  recipeService!: RecipeService;


  constructor(recipeService: RecipeService) {

    this.recipeService = recipeService;

   }

  ngOnInit(): void {

    this.recipeService.getRecipeIdObs().subscribe((data) => this.recipeToBeDisplayed.idMeal = data);
    this.getRandomRecipe();




  }

  async getRecipeInfoById(recipeId: number) {

    this.recipeToBeDisplayed = await this.recipeService.getRecipeInfoById(recipeId);
    this.ingredients = this.recipeToBeDisplayed.strIngredients;

  }

  async getRandomRecipe() {

    this.recipeToBeDisplayed = await this.recipeService.getRandomRecipe();
    this.ingredients = this.recipeToBeDisplayed.strIngredients;
    
  }



}
