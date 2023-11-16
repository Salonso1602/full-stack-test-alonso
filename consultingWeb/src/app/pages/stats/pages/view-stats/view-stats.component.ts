import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeService } from 'src/app/core/services/employee.service';
import { HistogramComponent } from 'src/app/shared/components/histogram/histogram.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-stats',
  templateUrl: './view-stats.component.html',
  styleUrls: ['./view-stats.component.css']
})
export class ViewStatsComponent implements OnInit {

  @ViewChild("graph")
  graph! : HistogramComponent;

  constructor(private empsServ : EmployeeService, private router : Router) { }

  empsByManager : {label : String, y : Number}[] = Array();
  

  ngOnInit(): void {
    this.empsServ.getEmployeesByManager().subscribe((data) => {
      if(data){
        data.forEach((element) => {
          this.empsByManager.push(
            {
            label : element.manager.firstName +" "+ element.manager.lastName + " "+element.manager.employeeId,
            y : element.dependants.length
          })});
            this.graph.setData(this.empsByManager);
      }
    })
  }

  goToHome(){
    this.router.navigate(['home'])
  }

}
