import { Component, OnInit } from '@angular/core';
import { FoodPicService } from 'src/app/food-pic.service';
import { Recipe } from 'src/app/Recipe';

@Component({
  selector: 'app-pic5',
  templateUrl: './pic5.component.html',
  styleUrls: ['./pic5.component.css']
})
export class Pic5Component implements OnInit {
  data: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""
  
  };
  
    constructor(private foodServe: FoodPicService) {
      this.foodServe.getFoodById(53056).then(data => {
        console.log(data);
        this.data=data;
      });
     }
    
    ngOnInit(): void {
     
    }
}
