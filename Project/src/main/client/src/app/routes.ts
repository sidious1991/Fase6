import { Routes } from '@ngrx/router';

const url = "Fase6"

export const routes: Routes = [
  {
    path: '/'+url,
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./projects/projects.component').ProjectsComponent);
      })
    })
  },
  {
    path: '/'+url+'/grid',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./grid/grid.component').GridComponent);
      })
    })
  },
  {
    path: '/'+url+'/charts',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./charts/charts.component').ChartsComponent);
      })
    })
  },
  {
    path: '/'+url+'/scheduleChart',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./scheduleChart/scheduleChart.component').ScheduleChartComponent);
      })
    })
  },
  {
    path: '/'+url+'/outcomes',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./outcomes/outcomes.component').OutcomesComponent);
      })
    })
  },
  {
    path: '/'+url+'/reports',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./reports/reports.component').ReportsComponent);
      })
    })
  },
  {
    path: '/'+url+'/feedbacks',
    loadComponent: () => new Promise(resolve => {
      (require as any).ensure([], require => {
        resolve(require('./feedbacks/feedbacks.component').FeedbacksComponent);
      })
    })
  }
];
