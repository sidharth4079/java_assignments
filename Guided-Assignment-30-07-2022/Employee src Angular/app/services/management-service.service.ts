import { Injectable } from '@angular/core';
import { Employee } from '../common/employee';
import { HttpClient } from '@angular/common/http';
import { Observable,map } from 'rxjs';
import { Department } from '../common/department';

@Injectable({
  providedIn: 'root'
})
export class ManagementServiceService {
  
  empurl = "http://localhost:8080/api/employees"
  depturl = "http://localhost:8080/api/dept"
  constructor(private httpclient :HttpClient) { }
  getAllEmployees() :Observable<Employee[]>{
    // console.log(this.httpclient.get<getEmployeeResponse>(this.empurl).pipe(map(response => response._embedded.employees)))
    return this.httpclient.get<getEmployeeResponse>(this.empurl).pipe(map(response => response._embedded.employees))
  }
  getAllDepartments() :Observable<Department[]> {
    // console.log(this.httpclient.get<getDepartmentResponse>(this.depturl).pipe(map(response =>response._embedded.departments)))
    return this.httpclient.get<getDepartmentResponse>(this.depturl).pipe(map(response =>response._embedded.departments))
  }

}

interface getEmployeeResponse {
  _embedded : {
    employees : Employee[]
  }
}

interface getDepartmentResponse{
  _embedded :{
    departments : Department[]
  }
}