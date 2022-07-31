import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { Routes,RouterModule, Route } from '@angular/router';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const route : Routes =[
  {path : '',component:WelcomeComponent},
  {path:'product',component:ProductListComponent},
  {path:'category',component:CategoryListComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(route),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
