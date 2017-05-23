import { Component, Input } from '@angular/core';

import { Store } from '@ngrx/store';
import { AppState } from '../appState';

import { RetrospectiveReport } from "../models/retrospectiveReport.model"; 

@Component({
  moduleId: module.id,
  selector: 'feedbacks-cmp',
  template: require('./feedbacks.component.html'),
  styles: [require('./feedbacks.component.css')]
})

export class FeedbacksComponent {
  
  retrospectiveReport: RetrospectiveReport[];
  RRPriority: string[] = [];
  RRDescription: string[] = [];
  RRconclusion : string[] = [];
  RRlastModfied : string[] = [];

  constructor(
      private _store: Store<AppState>
    ) {   
      _store.select<RetrospectiveReport[]>('retrospectiveReport')
    .subscribe(retrospectiveReport => this.retrospectiveReport = retrospectiveReport);
  }
  
  

  ngOnInit() {
 //   console.log("Load Elements on Feedbacks");
 //   console.log(this.retrospectiveReport);
  }


  showFeedback(index : number){
 //   console.log(index);

    var length = this.RRPriority.length;
    
    for (var j = 0; j < length; j++) {
      this.RRDescription.pop();
      this.RRPriority.pop();  
      this.RRlastModfied.pop();
      this.RRconclusion.pop();
    }

    var j = 0;
    while(this.retrospectiveReport[j] != null){
      for (var i = 0; i < this.retrospectiveReport[j].ids.length; i++) {
        if(this.retrospectiveReport[j].ids[i] == index){
          this.RRPriority.push(this.retrospectiveReport[j].priorityList[i]);
          this.RRDescription.push(this.retrospectiveReport[j].descriptionList[i]);
          this.RRlastModfied.push(this.retrospectiveReport[j].lastModified);
          this.RRconclusion.push(this.retrospectiveReport[j].conclusion);
        }   
      }
      j++;
    }

//    console.log("Elementi caricati negli Array:");
//    console.log(this.RRDescription);
//    console.log(this.RRPriority);
//    console.log(this.RRlastModfied);
//    console.log(this.RRconclusion);
  }
}