import { Component, Input, AfterViewInit } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'sidebar-cmp',
  template: require('./sidebar.component.html'),
  styles: [require('./sidebar.component.css')]
})
export class SidebarComponent implements AfterViewInit {

  @Input('currentUser') currentUser: any = {
    name: "",
    surname: "",
    pic: ""
  }

  ngAfterViewInit() {
    require('../../../../assets/js/custom.js');
  }

}
