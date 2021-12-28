import { Component, Input, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../Recipe';
import { reduce } from 'rxjs';
import { ThrowStmt } from '@angular/compiler';
import { ActivatedRoute } from '@angular/router';



//'recipedetailed/:id' id is like path param, so go to localhost:4200/recipedetailed/idofrecipe to bring up the detailed recipe page of the id of the recipe in there
                                                  //      ^ obs will change when we deploy to AWS, but dont worry about that for now



@Component({
  selector: 'app-recipedetailed',
  templateUrl: './recipedetailed.component.html',
  styleUrls: ['./recipedetailed.component.css']
})
export class RecipedetailedComponent implements OnInit {


  id!: string | null;
  ingredients : Array<string> = new Array<string>(); 

  recipeToBeDisplayed: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""

  };

  recipeService!: RecipeService;


  constructor(recipeService: RecipeService, private route: ActivatedRoute) {

    this.recipeService = recipeService;

   }

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id');

    if(this.id == null) {

      //throw some kind of error

    } else {

      this.getRecipeInfoById(parseInt(this.id));

    }




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
