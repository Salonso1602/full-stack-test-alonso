import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Employee } from '../interfaces/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.backendUrl+"/employees";

  constructor(private http : HttpClient) { }

  getAllEmployees() : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
  }

  getEmployeeById(employeeId : String) : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+'/'+employeeId);
  }

  getEmployeeByManager(managerId : String) : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+'/managedBy/'+managerId);
  }
}
