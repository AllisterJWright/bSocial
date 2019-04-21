import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { Posting } from '../Posting';
import { All_U, Storage } from '../Temp';

@Component({
  selector: 'app-profile2',
  templateUrl: './profile2.component.html',
  styleUrls: ['./profile2.component.css']
})
export class Profile2Component implements OnInit {
  user : User = All_U[1];
  posting : Posting[] = Storage;

  constructor() { }

  ngOnInit() {
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
