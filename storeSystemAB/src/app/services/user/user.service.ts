import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userStatus: boolean | undefined;

  loggedIn = new BehaviorSubject(null);
  userLogin = this.loggedIn.asObservable();

  changeUserStatus(status: null) {
    this.loggedIn.next(status);
  }

  constructor() { }

  _userStatus: boolean = false;
  _CodePlayerStatus: boolean = false;
  _updatePlayerStatus: boolean = false;

}
