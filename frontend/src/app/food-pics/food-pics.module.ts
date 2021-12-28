import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FoodPicsRoutingModule } from './food-pics-routing.module';
import { Pic1Component } from './pic1/pic1.component';
import { Pic2Component } from './pic2/pic2.component';
import { Pic3Component } from './pic3/pic3.component';
import { Pic4Component } from './pic4/pic4.component';
import { Pic5Component } from './pic5/pic5.component';
import { Pic6Component } from './pic6/pic6.component';


@NgModule({
  declarations: [
    Pic1Component,
    Pic2Component,
    Pic3Component,
    Pic4Component,
    Pic5Component,
    Pic6Component
  ],
  imports: [
    CommonModule,
    FoodPicsRoutingModule
  ]
})
export class FoodPicsModule { }
