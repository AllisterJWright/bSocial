import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor(private conn : ConnectService, private router: Router) { }

  ngOnInit() {

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
