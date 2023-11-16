import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeSummaryComponent } from './components/employee-summary/employee-summary.component';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { HistogramComponent } from './components/histogram/histogram.component';
import { CanvasJSAngularChartsModule } from '@canvasjs/angular-charts';



@NgModule({
  declarations: [
    EmployeeSummaryComponent,
    HistogramComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatDialogModule,
    MatButtonModule,
    MatDividerModule,
    CanvasJSAngularChartsModule
  ],
  exports : [
    HistogramComponent
  ]
})
export class SharedModule { }
