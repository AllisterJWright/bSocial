import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-forgot',
  templateUrl: './forgot.component.html',
  styleUrls: ['./forgot.component.css']
})
export class ForgotComponent implements OnInit {

  constructor(private conn : ConnectService, private rout : Router) { }

  ngOnInit() {
  }

  ForgotPass(FP : any){
    this.conn.forgotPass(FP.value.Email).subscribe(
      data => {
        if(data == null){
          console.log("Email doesn't exist or already exist");
        }else{
          console.log(FP.value);
          this.rout.navigate(['/login']);
        }
      },
      error => {
        console.log("Email doesn't exist or already exist");
      }
    );
  }

}
