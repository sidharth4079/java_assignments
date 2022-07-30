import { Component, OnInit } from '@angular/core';
import { Salesperson } from '../salesperson';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {


  constructor() { }

  salesPersonsModel : Salesperson[]=[ new Salesperson("Ajay","Singh","Ajay.s@gmail.com",25500,"600"),
                                    new Salesperson("Arun","Kumar","Arun.k@gmail.com",25000,"300"),
                                    new Salesperson("Raj","Goyal","Raj.g@gmail.com",37500,"550"),
                                    new Salesperson("Vinay","Gupta","Vinay.g@gmail.com",50000,"610"),
                                    new Salesperson("Shubhdeep","Sidhu","Shubh.s@gmail.com",60000,"125"),]

  formModel : Salesperson = new Salesperson("","","",0,"")
  ngOnInit(): void {
    console.log(this.salesPersonsModel)
  }
  onSubmit():void{
    this.salesPersonsModel.push(this.formModel)
  }

}
