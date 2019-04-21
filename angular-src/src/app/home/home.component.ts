import { Component, OnInit } from '@angular/core';
import { Posting } from '../Posting';
import { Storage } from '../Temp';
import { ConnectService } from '../connect.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posting : Posting[] = Storage;
  postin : any;


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
  }

}
