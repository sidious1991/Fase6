import { Component } from '@angular/core';
import { TopbarComponent, SidebarComponent, FooterComponent } from './shared/shared';
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { AppService } from './app.service';

@Component({
  selector: 'ng2-app',
  template: require('./app.component.html'),
  styles: [require('./app.component.css')],
  directives: [TopbarComponent, SidebarComponent, FooterComponent],
  providers: [AppService]
})

export class AppComponent {

  currentUser: any = {
    name: "",
    surname: "",
    pic: ""
  };

  constructor(private _appService: AppService) {
    this.getUsers();
  }

  listCookies() {
    let cookies = Cookie.getAll();
    // console.log(cookies);
  }

  getUsers() {
    let usercookie = Cookie.get('username');
    this._appService.getUsers().subscribe(
      users => {
        users.filter( user => new RegExp('/*Company expert/*').test(user.role) )
          .filter(user => user.username === usercookie.replace(/"/g,''))
          .map(user => Object.assign(this.currentUser, user));
      }
    );
  }

}
