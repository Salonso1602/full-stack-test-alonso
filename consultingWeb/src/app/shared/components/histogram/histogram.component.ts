import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-histogram',
  templateUrl: './histogram.component.html',
  styleUrls: ['./histogram.component.css']
})
export class HistogramComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

  @Input() histogramTitle: String = "";
  data?: { label: String, y: Number }[] = [];

  chartOptions = {
    title: {
      text: this.histogramTitle
    },
    animationEnabled: true,
    axisY: {
      includeZero: true
    },
    data: [{
      type: "column", //change type to bar, line, area, pie, etc
      //indexLabel: "{y}", //Shows y value on all Data Points
      indexLabelFontColor: "#5A5757",
      dataPoints: this.data
    }]
  }

  setData(data: { label: String, y: Number }[]) {
    console.log(data)
    this.chartOptions = {
      ...this.chartOptions, 
      data: [{
        type: "column", //change type to bar, line, area, pie, etc
        //indexLabel: "{y}", //Shows y value on all Data Points
        indexLabelFontColor: "#5A5757",
        dataPoints: data
      }]
    }
  }

}
