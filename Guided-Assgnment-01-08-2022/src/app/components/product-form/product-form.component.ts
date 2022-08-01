import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { Productcategory } from 'src/app/common/productcategory';
import { EcommerceService } from 'src/app/services/ecommerce.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit { 
  product : Product= new Product(0,"","","",0,"",0,"","",0);
  categories : Productcategory[] 
  constructor(private service : EcommerceService,
    private route : Router) { }

  ngOnInit(): void {
    this.listOfCategory()
  }

  listOfCategory(){
    this.service.getAllCategory().subscribe(data=>{
      this.categories=data
    })
  }

  onSubmit(): void{
    this.service.saveProduct(this.product).subscribe(() =>{
      this.route.navigateByUrl("/shop")
    })
  }

  gotoHome(){
    this.route.navigateByUrl("/")
  }

  viewProduct(){
    this.route.navigateByUrl("/shop")
  }
}
