import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { Routes,RouterModule, Route } from '@angular/router';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { ProductFormComponent } from './components/product-form/product-form.component';
import { AddCartComponent } from './components/add-cart/add-cart.component';
import { CartComponent } from './components/cart/cart.component';

const route : Routes =[
  {path : '',component:WelcomeComponent},
  {path:'shop',component:ProductListComponent},
  {path:'category',component:CategoryListComponent},
  {path: 'merchant',component:ProductFormComponent},
  {path: 'cart',component:CartComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    WelcomeComponent,
    ProductFormComponent,
    AddCartComponent,
    CartComponent
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
