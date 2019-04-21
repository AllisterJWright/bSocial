import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';
import { User } from '../User';
import { routerNgProbeToken } from '@angular/router/src/router_module';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  SavedUser: User;
  Logged : Boolean;

  constructor(private conn : ConnectService, private router: Router, private saveUser: DataSharingService) { }

  ngOnInit() {
    
    this.saveUser.LN.subscribe(Logged => this.Logged = Logged);
    this.saveUser.SU1.subscribe(SavedUser => this.SavedUser = SavedUser);
    console.log(this.SavedUser);
  }

  SetUser(user: User){
    this.saveUser.changeLogInUser(user);
    
  }

  Log( ULog : any){
    console.log(ULog);
    this.saveUser.ToggleLogged(true);
    this.SetUser(new User('Diddy Kong', 'Banana@yahoo.com', 'SecretJungleKing', 'Banana', 'http://www.superluigibros.com/images/media/artwork/ds/hoops3on3/characters/large/Diddy_Kong.jpg'));
    console.log(this.SavedUser);
    this.router.navigate(['/home']);
    
    /*
    this.conn.loginUser(ULog.value).subscribe(
      data => {
        console.log(data);
        alert("Were In");
        SetUser(data);
        this.router.navigate(['/home']);
      },
      error => {
        console.log("Error");
        alert("Wrong Username or Password.");
      }
    );
    console.log(ULog.value);
    */
  }
  

}
