import { Component, Input } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'topbar-cmp',
  template: require('./topbar.component.html')
})
export class TopbarComponent {
  
  @Input('currentUser') currentUser: any = {
    name: "",
    surname: "",
    pic: ""
  }

}
