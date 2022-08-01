import { Component, OnInit } from '@angular/core';
import { EcommerceService } from 'src/app/services/ecommerce.service';
import { Product } from 'src/app/common/product';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[]

  constructor(private service : EcommerceService ,
              private route : Router) { }

  formModel : Product = new Product(0,"","","",0,"",0,"","",0)

  ngOnInit(): void {
    this.listOfProducts()
  }

  listOfProducts(){
    this.service.getAllProduct().subscribe(data => {
      this.products = data
    })
  }
  addProduct(){
    this.route.navigateByUrl("/merchant")
  }
  gotoHome(){
    this.route.navigateByUrl("/")
  }
}