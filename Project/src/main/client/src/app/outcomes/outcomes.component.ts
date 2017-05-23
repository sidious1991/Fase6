import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { OutcomesService } from './outcomes.service';
import { AppState } from '../appState';
import { Report } from '../models/report.model';

import { Router } from '@ngrx/router';
import { ScheduleChart } from '../models/scheduleChart.model';
import { OutPipe } from './outcomes.pipe';

@Component({
    moduleId: module.id,
    selector: 'outcomes-cmp',
    template: require('./outcomes.component.html'),
    styles: [require('./outcomes.component.css')],
    pipes: [OutPipe],
    providers: [OutcomesService]
})
export class OutcomesComponent implements OnInit {

    changes: any;
    scheduleChart: ScheduleChart[];
    planOut: any = {
        ADD: [], 
        MOD: [], 
        DEL: [], 
        ScheduleChart: [], 
        Report: "", 
        newCycle: false
    };
    newCycle: boolean;
    report :  any;

    constructor(
        private _store: Store<AppState>,
        private _router: Router,
        private _outcomesService: OutcomesService
    ) {
        _store.select<any[]>('changes').subscribe(
            chs => {
                this.changes = chs;
                this.planOut.ADD = this.changes.add;
                this.planOut.MOD = this.changes.mod;
                this.planOut.DEL = this.changes.del;
            }
        );
        _store.select<ScheduleChart[]>('scheduleChart').subscribe(
            sc => {
                this.scheduleChart = sc;
                this.planOut.ScheduleChart = this.scheduleChart;
            }
        );
        _store.select<Report>('report')
        .subscribe(rp => {
             this.planOut.Report = rp.report;
             this.report = rp.report;
        });
        this.newCycle = false;
    }

    ngOnInit() {
        
    }

    ngOnDestroy() {
        // this._store.unsubscribe();
    }

    onSending(): void{
        this.planOut.newCycle = this.newCycle;
        this._outcomesService.postOutcomes(this.planOut).subscribe(
            data => console.log(data),
            err => console.log(err)
        );
    }

}
