import { Component, OnInit, AfterViewInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

import { AppUtilService } from '../appUtil.service';
import { ChartsService } from './charts.service';
import { ChartDirective } from './chart.directive';

import { Project } from '../models/project.model';
import { Store } from '@ngrx/store';
import { AppState } from '../appState';

@Component({
  moduleId: module.id,
  selector: 'charts-cmp',
  template: require('./charts.component.html'),
  styles: [require('./charts.component.css')],
  providers: [ChartsService],
  directives: [ChartDirective]
})
export class ChartsComponent implements OnInit, AfterViewInit, OnDestroy {
  serverData: any = [];
  validData: boolean = true;
  project: Project;
  goals = [];
  graphType = ['line', 'bar'];
  ready: Subscription;
  
  goalsDisplay: string[];
  metricsDisplay: string[];

  selectedGoal;
  selectedMetric;
  selectedGraph = 'line';

  chartType = 'line';
  chartData = {
    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
    datasets: [{
        label: '# of Votes',
        data: [1, 3, 5, 7, 9, 11],
        backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
    }]
  };
  chartOptions = {
    scales: {
        yAxes: [{
            ticks: {
                beginAtZero:true
            }
        }]
    }
  };

  templateData = {
    type: this.chartType,
    data: this.chartData
    // options: this.chartOptions
  };

  constructor(
    private _chartsService: ChartsService,
    private _utilService: AppUtilService,
    private _store: Store<AppState>
  ) {
    _store.select<Project>('original')
      .subscribe(project => this.project = project);
  }

  ngOnInit() {
    this.ready = this._chartsService.ready.subscribe(data => this.getData());
    // this.getData();
  }

  ngAfterViewInit() {
    
  }

  ngOnDestroy() {
    // this.ready.unsubscribe();
    // this._store.unsubscribe();
  }

  getData() {
    this._chartsService.getChartsData().subscribe(
      data => {
        this.serverData = data;
        this.initializeData();
      },
      err => console.log(err)
    );
  }

  initializeData() {
    this.parsePrj(this.project, this.goals);

    this.goalsDisplay = this.displayGoals();
    this.selectedGoal = this.goalsDisplay[0];

    this.metricsDisplay = this.displayMetrics();
    this.selectedMetric = this.metricsDisplay[0];

    this.parseData();
  }

  extractData() {
    let res = [];
    let goal = this.goals.filter(goal => this.selectedGoal === goal.goalId);
    let metricData = this.serverData.filter(data => this.selectedMetric === data.metricRef.metricId);
    goal.forEach(g => {
      g.strs.forEach(str => {
        metricData.filter(data => data.strategyRef.strategyId === str).forEach(d => res.push(d));
      });
    })
    return res;
  }

  dynamicColors() {
    var r = Math.floor(Math.random() * 255);
    var g = Math.floor(Math.random() * 255);
    var b = Math.floor(Math.random() * 255);
    return "rgba(" + r + ","+ g + "," + b + ","+ 0.8 + ")";
  }

  parseData() {
    let chrdataset = [];
    let arr = this.extractData();
    let timeframe;
    if(arr.length === 0)
    {
      this.validData = false;
      this._chartsService.passChartData({});
      // console.log('empty dataset');
      return;
    }
    this.validData = true;
    this.goals.filter(goal => goal.goalId === this.selectedGoal).forEach(goal => timeframe = goal.timeFrame);
    arr.forEach(data => {
      chrdataset.push({
        label: 'Strategy ' + data.strategyRef.strategyId,
        backgroundColor: this.dynamicColors(),
        borderColor: this.dynamicColors(),
        pointBorderColor : "rgba(38, 185, 154, 0.7)",
        pointBackgroundColor : "rgba(38, 185, 154, 0.7)",
        pointHoverBackgroundColor : "#fff",
        pointHoverBorderColor : "rgba(220,220,220,1)",
        pointBorderWidth : 1,
        data: data.data
      });
    });
    this.templateData = {
      type: this.selectedGraph,
      data: {
        labels: this.setLabel(timeframe), 
        datasets: chrdataset
      }
      // options: this.chartOptions
    };

    this._chartsService.passChartData(this.templateData);

  }

  setLabel(timeframe) {
    var result = new Array();
    var value_limit = +timeframe.value;
    var months = new Array(12);
    months[0] = "January";
    months[1] = "February";
    months[2] = "March";
    months[3] = "April";
    months[4] = "May";
    months[5] = "June";
    months[6] = "July";
    months[7] = "August";
    months[8] = "September";
    months[9] = "October";
    months[10] = "November";
    months[11] = "December";

    if(timeframe.label == "anno" || timeframe.label == "anni"){
      for (var i=0 ; i<= value_limit ; i++) {
        result.push(parseInt(timeframe.period)+i);
      }
    }
    else { 
      if(timeframe.label == "mese" || timeframe.label == "mesi"){
        var j=0;
        for (var i = 0; i< value_limit;i++) {
            result.push(months[(parseInt(timeframe.period)+i-1)%12]);
        }
      }
    }
    return result;
	}

  onGoalChange() {
    this.goals.filter(goal => goal.goalId === this.selectedGoal).forEach(goal => this.metricsDisplay = goal.mtrs);
    this.selectedMetric = this.metricsDisplay[0];
    this.parseData();
  }

  onMetricChange() {
    this.parseData();
  }

  onTypeChange() {
    this.parseData();
  }

  displayGoals() {
    let g = [];
    this.goals.forEach(el => g.push(el.goalId));
    return g;
  }

  displayMetrics() {
    let m = [];
    this.goals.filter(goal => goal.goalId === this.selectedGoal).
      forEach(goal => m = goal.mtrs);
    return m;
  }

  getTimeFrame(goalRef) {
    let timeframe = {};
    let time = goalRef.timeFrame;
    let start = goalRef.creationDate;

    let parsed = time.split(" ");
    let dateParsed = start.split("/");

    if(parsed[1]=="mesi"|| parsed[1]== "mese") {
			timeframe = {
        value : parsed[0],
        label : parsed[1],
        period : dateParsed[1]
        };
			}
			else {
        timeframe = {
					value : parsed[0],
					label : parsed[1],
					period : dateParsed[2]
				};
      }

    return timeframe;
  }
  
  extract(goalRef) {
    let obj = {
      goalId: goalRef.goalId,
      timeFrame: this.getTimeFrame(goalRef),
      strs: [],
      mtrs: []
    };
    goalRef.measurementRef.forEach(
      function(mg) {
        mg.metricsRef.forEach(
          function(mtr) {
            obj.mtrs.push(mtr.metricId);
          }
        );
      }
    );
    goalRef.strategyRef.forEach(
      function(str) {
        obj.strs.push(str.strategyId);
      }
    );
    return obj;
  }

  parsePrj(project, arr) {
    let chartCmp = this;
    Object.keys(project).forEach(function(key) {
      if(chartCmp._utilService.isObjectArray(project[key])) {
        if(key === 'goalRef') {
          project[key].forEach( function(el) { 
            if(
              el && 
              el.measurementRef && 
              el.measurementRef[0].metricsRef &&
              el.strategyRef
            ) {
              arr.push(chartCmp.extract(el));
            } /*
            else {
              arr.push({
                goalId: el.goalId,
                strs: [],
                mtrs: []
              });
            }
            */
          } );
        }
        project[key].forEach(function(el) {
          chartCmp.parsePrj(el, arr);
        });
      }
    });
  }

}
