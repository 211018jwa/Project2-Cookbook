import { Component, OnInit } from '@angular/core';
import { FoodPicService } from 'src/app/food-pic.service';
import { Recipe } from 'src/app/Recipe';

@Component({
  selector: 'app-pic3',
  templateUrl: './pic3.component.html',
  styleUrls: ['./pic3.component.css']
})
export class Pic3Component implements OnInit {
  data: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""
  
  };
  
    constructor(private foodServe: FoodPicService) {
      this.foodServe.getFoodById(53063).then(data => {
        console.log(data);
        this.data=data;
      });
     }
    
    ngOnInit(): void {
     
    }
}
