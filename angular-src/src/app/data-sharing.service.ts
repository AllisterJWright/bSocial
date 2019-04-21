import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import {User} from './User';

@Injectable({
  providedIn: 'root'
})
export class DataSharingService {

  private SavedUser = new BehaviorSubject<User>(null);
  private SavedUser2 = new BehaviorSubject<User>(null);

  SU1 = this.SavedUser.asObservable();
  SU2 = this.SavedUser2.asObservable();

  constructor() { }

  changeLogInUser(user : User){
    this.SavedUser.next(user);
  }
  searchOtherUser(user2 : User){
    this.SavedUser2.next(user2);
  }
}
