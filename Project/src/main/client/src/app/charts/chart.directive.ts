import { Directive, ElementRef, OnInit, AfterViewInit, OnDestroy } from '@angular/core';
import { ChartsService } from './charts.service';
import { Subscription } from 'rxjs/Subscription';

declare var Chart: any;

@Directive({
  selector: '[chart]'
})
export class ChartDirective implements OnInit, OnDestroy, AfterViewInit {
  element: any;
  myChart: any;
  chartData: any;
  subscription: Subscription;
  graphCreated: boolean = false;
  canvas: any;
  ctx: any;

  constructor(el: ElementRef, private _chartsService: ChartsService) {
    this.element = el.nativeElement;
    this.subscription = this._chartsService.chartData.subscribe(
      data => {
        this.chartData = data;
        this.createGraph();
      }
    );
  }

  ngOnInit() {

  }

  ngAfterViewInit() {
    this._chartsService.readyToReceive(true);
  }

  createGraph() {
    if(this.chartData.data) {
      if(this.graphCreated) {
        this.myChart.destroy();
      } else {
        this.canvas = this.element;
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
