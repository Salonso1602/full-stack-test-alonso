import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeSummaryComponent } from './components/employee-summary/employee-summary.component';
import {MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';




@NgModule({
  declarations: [
    EmployeeSummaryComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatDialogModule,
    MatButtonModule,
    MatDividerModule
  ]
})
export class SharedModule { }
