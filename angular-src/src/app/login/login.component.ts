import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';
import { User } from '../User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

SavedUser: User;

  constructor(private conn : ConnectService, private router: Router, private saveUser: DataSharingService) { }

  ngOnInit() {
    
  }

  SetUser(user: User){
    this.saveUser.changeLogInUser(user);
  }

  Log( ULog : any){
    
  }
    /*
    this.conn.loginUser(ULog.value).subscribe(
      data => {
          console.log(data);
        alert("Were In");
        this.router.navigate(['/home']);
        return data;
      },
      error => {
        console.log("Error");
        alert("Wrong Username or Password.");
      }
    );
    console.log(ULog.value);
  }
  */

}
