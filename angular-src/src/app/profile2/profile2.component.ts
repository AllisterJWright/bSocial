import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { Posting } from '../Posting';
import { All_U, Storage } from '../Temp';
import { DataSharingService } from '../data-sharing.service';

@Component({
  selector: 'app-profile2',
  templateUrl: './profile2.component.html',
  styleUrls: ['./profile2.component.css']
})
export class Profile2Component implements OnInit {
  user : User;
  posting : Posting[] = Storage;

  constructor(private saveUser : DataSharingService) { }

  ngOnInit() {
    this.saveUser.SU2.subscribe(user => this.user = user)
    console.log(this.user);
    /*
    this.posting = this.conn.showPost(user.username).subscribe(
      data => {
        return data;
      },
      error => {
        alert("no post");
      }
    )
    */
  }

}
