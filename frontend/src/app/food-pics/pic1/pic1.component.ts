import { Component, OnInit } from '@angular/core';
import { Recipe } from 'src/app/Recipe';
import { RecipeService } from 'src/app/recipe.service';
import { FoodPicService } from '../../food-pic.service';
@Component({
  selector: 'app-pic1',
  templateUrl: './pic1.component.html',
  styleUrls: ['./pic1.component.css']
})
export class Pic1Component implements OnInit {
 allFood: Recipe = { 

  idMeal: 0,
  strMeal: "",
  strIngredients: new Array<string>(),
  strInstructions: "",
  strMealThumb: ""

};

  constructor(private foodServe: RecipeService) {
    this.foodServe.getRecipeInfoById(52765).then(data => {
      console.log(data);
      this.allFood=data;
    });
   }
  
  ngOnInit(): void {
   
  }

}
