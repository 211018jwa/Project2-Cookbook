import { Component, OnInit } from '@angular/core';
import { FoodPicService } from 'src/app/food-pic.service';
import { Recipe } from 'src/app/Recipe';

@Component({
  selector: 'app-pic6',
  templateUrl: './pic6.component.html',
  styleUrls: ['./pic6.component.css']
})
export class Pic6Component implements OnInit {

  data: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""
  
  };
  
    constructor(private foodServe: FoodPicService) {
      this.foodServe.getFoodById(52794).then(data => {
        console.log(data);
        this.data=data;
      });
     }
    
    ngOnInit(): void {
     
    }
}
