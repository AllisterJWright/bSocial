import { Component, Input, OnInit } from '@angular/core';
import { DataSharingService } from './data-sharing.service';
import { User } from './User';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'bSocial';
  
  public Logged : boolean;
  public user1 : User;
  public user2 : User;

  ngOnInit(){
    
    this.saveUser.LN.subscribe(Logged => this.Logged = Logged);
    this.saveUser.SU1.subscribe(user1 => this.user1 = user1);
    this.saveUser.SU2.subscribe(user2 => this.user2 = user2);
  }

  Logout(){
    this.saveUser.ToggleLogged(false);
    this.saveUser.changeLogInUser(null);
    this.saveUser.searchOtherUser(null);
    console.log(this.user1);
  }

  constructor(private saveUser: DataSharingService){}
}
