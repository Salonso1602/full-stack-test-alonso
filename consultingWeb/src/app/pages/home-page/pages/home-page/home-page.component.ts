import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/core/interfaces/Employee';
import { EmployeeService } from 'src/app/core/services/employee.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private empServ : EmployeeService) { }

  emps : Employee[] = []

  ngOnInit(): void {
    this.empServ.getAllEmployees().subscribe(employees => {
      this.emps = employees
    })
  }

  test(item : Employee){
    alert(item.email)
  }

}
