import { Component, OnInit, AfterViewInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { ScheduleChart } from '../models/scheduleChart.model';
import { ScheduleChartDirective } from './scheduleChart.directive';


import { Store } from '@ngrx/store';
import { AppState } from '../appState';
import { ScheduleChartActions } from '../actions/scheduleChart.actions';
import { ScheduleChartService } from './scheduleChart.service';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    selector: 'schedulechart-cmp',
    template: require('./scheduleChart.component.html'),
    providers: [ScheduleChartService],
    directives: [ScheduleChartDirective]
})
export class ScheduleChartComponent implements OnInit, AfterViewInit, OnDestroy {

    scheduleChart: any[];
    existSchedule: boolean = true;
    ready: Subscription;

    constructor(
        private _store: Store<AppState>,
        private _scheduleChartService: ScheduleChartService
        ) {
    }

    ngOnInit() {
        this.getData();
    }

    ngAfterViewInit() {

    }

    ngOnDestroy() {
        // this.ready.unsubscribe();
        // this._store.unsubscribe();
    }

    getData() {
        this._store.select<ScheduleChart[]>('scheduleChart').subscribe(
            sch => this.scheduleChart = sch
        );
        this.buildChart();
    }

    getScheduleChart() {

        return this.scheduleChart;
    }

    modifySch(form: Object): void {

        Object.keys(form).
            filter(key => {
                if (typeof this.scheduleChart[key] === "number") {
                    return ((!(form[key] === "" && this.scheduleChart[key] === null)) && form[key] !== JSON.stringify(this.scheduleChart[key]));
                }
                return ((!(form[key] === "" && this.scheduleChart[key] === null)) && form[key] !== this.scheduleChart[key]);
            }).
            map(key => {
                this.keySwitch(key,form);
            });
   
        this._store.dispatch(ScheduleChartActions.add(this.scheduleChart));
        this.buildChart();
    }

    private buildChart(): void {

        let chartType = 'line';
        let chartData = {
            datasets: []
        };
        let chartOptions = {
            scales: {
                xAxes: [{
                    type: 'time',
                    time: {
                        displayFormats: {
                            quarter: 'DD MM YYYY'
                        }
                    }
                }],
                yAxes: [{
                    ticks: {
                        stepSize: 1
                    }
                }]
            }
        };

        let i = 0;
        let start;
        let end;
        let colors = ['pink','yellow','brown','purple','blue','red','green'];
        this.scheduleChart.forEach(element => {
            let data: any[] = [];
            let dataset;
            start = {x: moment(element.startDate, "DD-MM-YYYY"), y: i};
            end = {x: moment(element.lastDate, "DD-MM-YYYY"), y: i};
            data.push(start);
            data.push(end);
            dataset = {
                label: 'Phase ' + element.fase,
                fill: false,
                backgroundColor: colors[i],
                borderColor: colors[i],
                data: data
            };
            chartData.datasets.push(dataset);
            i += 1;
        });

        let templateData = {
            type: chartType,
            data: chartData,
            options: chartOptions
        };

        this._scheduleChartService.passChartData(templateData);
    }

    private keySwitch(key, form: Object): void {

        switch (key) {
            case "00":
                this.scheduleChart[0].startDate = form[key];
                break;

            case "01":
                this.scheduleChart[0].lastDate = form[key];
                break;

            case "10":
                this.scheduleChart[1].startDate = form[key];
                break;

            case "11":
                this.scheduleChart[1].lastDate = form[key];
                break;

            case "20":
                this.scheduleChart[2].startDate = form[key];
                break;

            case "21":
                this.scheduleChart[2].lastDate = form[key];
                break;

            case "30":
                this.scheduleChart[3].startDate = form[key];
                break;
            
            case "31":
                this.scheduleChart[3].lastDate = form[key];
                break;

            case "40":
                this.scheduleChart[4].startDate = form[key];
                break;

            case "41":
                this.scheduleChart[4].lastDate = form[key];
                break;

            case "50":
                this.scheduleChart[5].startDate = form[key];
                break;
            
            case "51":
                this.scheduleChart[5].lastDate = form[key];
                break;
            
            case "60":
                this.scheduleChart[6].startDate = form[key];
                break;
            
            case "61":
                this.scheduleChart[6].lastDate = form[key];
                break;
        
            default:
                // throw an exception;
                break;
        }
    }
}
