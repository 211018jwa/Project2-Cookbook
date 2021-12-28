import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { NavbarComponent } from './navbar/navbar.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { RecipedetailedComponent } from './recipedetailed/recipedetailed.component';
import { RecipesummaryComponent } from './recipesummary/recipesummary.component';
import { LoginComponent } from './login/login.component';
import { RandomRecipeComponent } from './random-recipe/random-recipe.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { FoodPicsRoutingModule } from './food-pics/food-pics-routing.module';
import { Pic1Component } from './food-pics/pic1/pic1.component';
import { Pic2Component } from './food-pics/pic2/pic2.component';
import { Pic3Component } from './food-pics/pic3/pic3.component';
import { Pic4Component } from './food-pics/pic4/pic4.component';
import { Pic5Component } from './food-pics/pic5/pic5.component';
import { Pic6Component } from './food-pics/pic6/pic6.component';

const routes: Routes = [
  { path: '', redirectTo: '/welcome', pathMatch: 'full' }, // Makes our program go to the welcome page by default, change '/welcome' to whatever the welcome page is called
  { path: 'welcome', component: WelcomeComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'userprofile', component: UserProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterUserComponent },
  { path: 'recipedetailed/:id', component: RecipedetailedComponent },
  { path: 'randomrecipe', component: RandomRecipeComponent },
  { path: 'recipesummary', component: RecipesummaryComponent },
  { path: 'login-page', component: LoginComponent },
  { path: 'food-pics', loadChildren: () => import(`./food-pics/food-pics.module`).then(m => FoodPicsRoutingModule) },
  { path: 'pic1', component:Pic1Component},
  { path: 'pic2', component:Pic2Component},
  { path: 'pic3', component:Pic3Component},
  { path: 'pic4', component:Pic4Component},
  { path: 'pic5', component:Pic5Component},
  { path: 'pic6', component:Pic6Component},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule],
})
export class AppRoutingModule {}
