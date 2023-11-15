import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Employee } from 'src/app/core/interfaces/Employee';
import { EmployeeService } from 'src/app/core/services/employee.service';
import { EmployeeSummaryComponent } from 'src/app/shared/components/employee-summary/employee-summary.component';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private empServ : EmployeeService, public dialog : MatDialog) { }

  emps : Employee[] = []

  ngOnInit(): void {
    this.empServ.getAllEmployees().subscribe((employees : Employee[]) => {
      this.emps = employees
      console.log(employees)
    })
  }

  openEmployeeDetails(item : Employee){
    const dialogRef = this.dialog.open(EmployeeSummaryComponent, {
      data: {employeeId : item.employeeId},
    });
  }

}
