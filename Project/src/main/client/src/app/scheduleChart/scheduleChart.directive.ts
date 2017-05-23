import { Directive, ElementRef, OnInit, AfterViewInit, OnDestroy} from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { Store } from '@ngrx/store';
import { AppState } from '../appState';
import { ScheduleChartService} from './scheduleChart.service';
import * as moment from 'moment';

declare var Chart: any;

@Directive({
  selector: '[scheduleChart]'
})
export class ScheduleChartDirective implements OnInit, OnDestroy, AfterViewInit{

  el: any;
  myChart: any;
  chartData: any;
  canvas: any;
  ctx: any;
  graphCreated: boolean = false;
  subscription: Subscription;

  constructor(element: ElementRef , private _scheduleChartService: ScheduleChartService) {
    this.el = element.nativeElement;
    this.subscription = this._scheduleChartService.chartData.subscribe(
      data => {
        this.chartData = data;
        this.createGraph();
      }
    );
  }

  ngOnInit(){

  }

  ngAfterViewInit() {
    this._scheduleChartService.readyToReceive(true);
  }

  createGraph(){

     if(this.chartData.data) {
      if(this.graphCreated) {
        this.myChart.destroy();
      } else {
        this.canvas = this.el;
        this.ctx = this.canvas.getContext('2d');
      }
      this.myChart = new Chart(this.ctx, this.chartData);
      this.graphCreated = true;
    }
    else {
      if(this.graphCreated) {
        this.myChart.destroy();
      }
    }    
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
