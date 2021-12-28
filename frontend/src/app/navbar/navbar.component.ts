import { Component, forwardRef, Input, OnInit, Output, ViewChild, ElementRef } from '@angular/core';
import { Observable, Subject} from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap, map, filter, tap} from 'rxjs/operators';
import { EventEmitter } from '@angular/core';
import { Recipe } from '../Recipe';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  recipes$!: Observable<Recipe[]>;
  searchTerms$ = new Subject<string>(); // a subject is both a source of observable values and an Observable itself. It can be subscribed the same way.
  searchIng$ = new Subject<string>();

  
  userImageLink = "https://img.icons8.com/small/64/000000/admin-settings-male.png";
  logoImageLink = "https://img.icons8.com/ios/50/000000/love-book.png";

  filterState!: string; // for ngModel of the dropdown
  filterValue!: string;
  constructor(private recipeService:  RecipeService) {}
   
  filterItem(event: any){
     if(event === 'name'){
      this.filterValue = "name";
     }
     if(event === 'ingredient'){
      this.filterValue = "ingredient";
    }
    if(event === 'category'){
      this.filterValue = "category";
    }
    if(event === 'area'){
      this.filterValue = "area";
    }
   
   }

  // Push a search term into the observable stream.
  search(term: string): void{
    this.searchTerms$.next(term);
  }
  
  loggedInTrue:boolean= true;
  loggedInFalse:boolean= false;
  // By default a ngIf happens if the boolean is true. Since by default, you don't have to be logged in, the sign in will be displayed
  // Need to change it later to change state based on status of logged in or not based on current user, will probably need to bind it's loggedInTrue to this component
  signOut(){
    console.log("logged out");
    this.loggedInTrue = !this.loggedInTrue
    this.loggedInFalse = !this.loggedInFalse; 
  }
  signIn(){
    console.log("logged in");
    this.loggedInTrue = !this.loggedInTrue
    this.loggedInFalse = !this.loggedInFalse; 
  }
  
  // filter by ingredient
  // filter by category ex. pasta, chicken, etc.
  // filter by area/ cuisine ex. italian, british, etc.
  ngOnInit(): void {
    this.loggedInTrue = true;
    this.loggedInFalse = false; 
      this.searchTerms$.pipe(
        // wait 300ms after each keystroke before considering the term
        debounceTime(300),
  
        // ignore new term if same as previous term
        distinctUntilChanged(),
  
        // Tried to make it switch to new search observable each time the term changes
        // switchMap((term: string) => this.recipeService.searchRecipes(term)) ,
        
      )
       .subscribe((term: string) => this.recipeService.searchRecipes(term));
      // testing for, depending on what the filter type is selected, it would change what would be subscribed to, thus calling a different url in recipe service.

    // if (this.filterValue =="name"){
    //   console.log(filterValue);
    //   this.searchTerms$.pipe(
    //     // wait 300ms after each keystroke before considering the term
    //     debounceTime(300),
  
    //     // ignore new term if same as previous term
    //     distinctUntilChanged(),
  
    //     // Tried to make it switch to new search observable each time the term changes
    //     // switchMap((term: string) => this.recipeService.searchRecipes(term)) ,
        
    //   )
    //    .subscribe((term: string) => this.recipeService.searchRecipes(term));
    // }
    
  } 
}

