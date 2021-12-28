import { Component, OnInit } from '@angular/core';
import { FoodPicService } from 'src/app/food-pic.service';
import { Recipe } from 'src/app/Recipe';
@Component({
  selector: 'app-pic2',
  templateUrl: './pic2.component.html',
  styleUrls: ['./pic2.component.css']
})
export class Pic2Component implements OnInit {
  data: Recipe = { 

    idMeal: 0,
    strMeal: "",
    strIngredients: new Array<string>(),
    strInstructions: "",
    strMealThumb: ""
  
  };
  
    constructor(private foodServe: FoodPicService) {
      this.foodServe.getFoodById(53011).then(data => {
        console.log(data);
        this.data=data;
      });
     }
    
    ngOnInit(): void {
     
    }
  

}
