import { Component, OnInit } from '@angular/core';
import { Posting } from '../Posting';
import { Storage, All_U } from '../Temp';
import { ConnectService } from '../connect.service';
import { User } from '../User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posting : Posting[] = Storage;
  postin : any;
  SearchUser : User[];
  Temp : User[];
  
  



  constructor(private conn : ConnectService) { }

  ngOnInit() {
    this.postin = this.conn.showPost('').subscribe(
      data => {
        return data;
      },
      error => {
        console.log("Error");
        alert("No Post");
      }
    )

    this.conn.callingAllUsers(null).subscribe(
      data => {
        this.SearchUser = data;
      },
      error => {
        alert("How could you screw this up. You simpleton!")
      }
    )

    this.Temp = All_U;
  }
  /*
  search(Zeta : any){
    console.log(Zeta);
  }
  */
}
