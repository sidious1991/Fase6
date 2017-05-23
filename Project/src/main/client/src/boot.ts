import { bootstrap } from '@angular/platform-browser-dynamic';
import { provide } from '@angular/core';
import { APP_BASE_HREF } from '@angular/common';
import { HTTP_PROVIDERS } from '@angular/http';
import { AppComponent } from './app/app.ts';
import { AppUtilService } from './app/appUtil.service';

import { provideRouter } from '@ngrx/router';
import { routes } from './app/routes';

import { provideStore, combineReducers } from '@ngrx/store';
import { compose } from "@ngrx/core/compose";
import { storeLogger } from "ngrx-store-logger";
import { originalReducer } from './app/reducers/original.reducer';
import { projectReducer } from './app/reducers/project.reducer';
import { changesReducer } from './app/reducers/changes.reducer';
import { statusReducer } from './app/reducers/status.reducer';
import { scheduleChartReducer } from './app/reducers/scheduleChart.reducer';
import { retrospectiveReportReducer } from './app/reducers/retrospectiveReport.reducer';
import { reportReducer } from './app/reducers/report.reducer';

import { disableDeprecatedForms, provideForms } from '@angular/forms';

bootstrap(AppComponent, [
  HTTP_PROVIDERS,
  provide(APP_BASE_HREF, { useValue: '/' }),
  AppUtilService,
  disableDeprecatedForms(),
  provideForms(),
  provideRouter(routes),
  provideStore(
    compose(
        storeLogger(), 
        combineReducers
    )({
      original: originalReducer,
      project: projectReducer,
      changes: changesReducer,
      status: statusReducer,
      scheduleChart: scheduleChartReducer,
      retrospectiveReport: retrospectiveReportReducer,
      report: reportReducer
    })
  )
]).catch((err: any) => console.error(err));
