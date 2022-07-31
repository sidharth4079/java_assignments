import { Component, OnInit } from '@angular/core';
import { ManagementServiceService } from 'src/app/services/management-service.service';
import { Employee } from 'src/app/common/employee';

@Component({
  selector: 'app-list-emp',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  employees : Employee[];
  constructor(private service :ManagementServiceService) { }
  formModel : Employee = new Employee ("",0,0,0,0,0,"","")
  ngOnInit(): void {
    this.listofEmployees()
  }
  onSubmit():void{
    this.employees.push(this.formModel)
  }
  listofEmployees(){
    this.service.getAllEmployees().subscribe(data=>{
      console.log(data)
      this.employees = data;
    })
  }

}