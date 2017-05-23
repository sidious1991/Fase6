import { Injectable, EventEmitter } from '@angular/core';

@Injectable()
export class GridEventsService {

  public modElement: EventEmitter<Object>;
  public addElement: EventEmitter<Object>;
  public delElement: EventEmitter<Object>;

  constructor() {
    this.modElement = new EventEmitter<Object>();
    this.addElement = new EventEmitter<Object>();
    this.delElement = new EventEmitter<Object>();
  }

  public emitElement(element: Object) {
    this.modElement.emit(element);
  }

  public emitTemplate(template: Object) {
    this.addElement.emit(template);
  }

  public emitDelete(element: Object) {
    this.delElement.emit(element);
  }

}
