import { Component, OnInit } from '@angular/core';
import { ManagementServiceService } from 'src/app/services/management-service.service';
import { Department } from 'src/app/common/department';

@Component({
  selector: 'app-dept-list',
  templateUrl: './dept-list.component.html',
  styleUrls: ['./dept-list.component.css']
})
export class DeptListComponent implements OnInit {

  constructor(private service :ManagementServiceService) { }
  departments : Department[];
  formModel : Department = new Department(0,"","");
  ngOnInit(): void {
    this.listofDepartments()
  }
  onSubmit():void{
    this.departments.push(this.formModel)
  }
  listofDepartments(){
    this.service.getAllDepartments().subscribe(data => {
      console.log(data)
      this.departments=data
    })
}
}