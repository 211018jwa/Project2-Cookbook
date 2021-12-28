import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Pic1Component } from './pic1/pic1.component';
import { Pic2Component } from './pic2/pic2.component';
import { Pic3Component } from './pic3/pic3.component';
import { Pic4Component } from './pic4/pic4.component';
import { Pic5Component } from './pic5/pic5.component';
import { Pic6Component } from './pic6/pic6.component';
import { RecipenameComponent } from './recipename/recipename.component';

const routes: Routes = [
  {
    path: '',
    component: RecipenameComponent
  },
  {
    path: 'image1',
    component: Pic1Component
  },
  {
    path: 'image2',
    component: Pic2Component
  },
  {
    path: 'image3',
    component: Pic3Component
  },
  {
    path: 'image4',
    component: Pic4Component
  },
  {
    path: 'image5',
    component: Pic5Component
  },
  {
    path: 'image6',
    component: Pic6Component
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FoodPicsRoutingModule { }
