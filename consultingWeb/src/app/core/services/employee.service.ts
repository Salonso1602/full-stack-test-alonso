import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { Employee } from '../interfaces/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.backendUrl+"/employees";

  private testEmps : Employee[] = [{
    employeeId : "0001",
    countryCode : "05080",
    firstName : "Leo",
    middleName : "Messi",
    lastName : "Messi",
    email : "messi@mail.com",
    type : "Student",
    timeType : "Fulltime",
    jobProfile : {
                  jobProfile : "Developer",
                  jobFamily : "App"
                },
    hireDate : new Date(),
    costCenter : {
      costCenterId : "0049",
      costCenterName : "CENTROOO AA"
    }
    }]

  constructor(private http : HttpClient) { }

  getAllEmployees() : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
    //return of(this.testEmps)
  }

  getEmployeeById(employeeId : String) : Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+'/'+employeeId);
  }

  getEmployeeByManager(managerId : String) : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+'/managedBy/'+managerId);
  }
}
