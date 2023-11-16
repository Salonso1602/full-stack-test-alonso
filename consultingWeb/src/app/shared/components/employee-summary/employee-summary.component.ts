import { Component, Inject, Input, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Employee } from 'src/app/core/interfaces/Employee';
import { EmployeeService } from 'src/app/core/services/employee.service';

@Component({
  selector: 'app-employee-summary',
  templateUrl: './employee-summary.component.html',
  styleUrls: ['./employee-summary.component.css']
})
export class EmployeeSummaryComponent implements OnInit {

  employee : Employee | undefined = undefined;

  constructor(private empserv : EmployeeService, @Inject(MAT_DIALOG_DATA) public data: {employeeId: string}, public dialogRef: MatDialogRef<EmployeeSummaryComponent>) { }

  ngOnInit(): void {
    this.empserv.getEmployeeById(this.data.employeeId).subscribe((emp : Employee) => {
      this.employee = emp;
    })
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
