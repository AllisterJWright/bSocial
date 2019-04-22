import { Component, OnInit } from '@angular/core';
import { Posting } from '../Posting';
import { Storage, All_U } from '../Temp';
import { ConnectService } from '../connect.service';
import { User } from '../User';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posting : Posting[] = Storage;
  postin : any;
  SearchUser : User[];
  Result : User[];
  searchText: string;
  
  



  constructor(private conn : ConnectService, private route : Router, private saveUser : DataSharingService) { }

  ngOnInit() {
    /*
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
        alert("How could you screw this up. You simpleton!");
      }
    )
    */
    this.Result = All_U;
  }
  
  // Function for going to another users Profile
  GoToProfile2(Prof:any){
    console.log(Prof);
    this.saveUser.searchOtherUser(Prof);
    this.route.navigate(['/profile2']);

    /*
    * this.conn.showPost(Prof.value.whatever)
    */
  }
  /*
  search(Zeta : any){
    console.log(Zeta);
  }
  */
}
