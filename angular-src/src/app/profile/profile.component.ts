import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { All_U,Storage } from '../Temp';
import { User } from '../User';
import { Posting } from '../Posting';
import { DomSanitizer, SafeResourceUrl, SafeUrl } from '@angular/platform-browser';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user : User = All_U[0];
  posting : Posting[] = Storage;
  public prof : boolean;
  Button : string = "Update";
  pic: string = this.user.displayImg;


  IUrl : string = '../../assets/gen-Ava.jpg';
  fileToUpload : File = null;


  constructor(private conn : ConnectService) { }

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

  toggle(){
    this.prof = !this.prof;

    if(this.prof)
      this.Button = "Profile";
    else 
      this.Button = "Update";
  }


  update(Profz:any){
    if(Profz.value.displayImg == ""){

    }else{
      let temp :File;
      temp = Profz.value.displayImg;
      this.user = new User(Profz.value.name, Profz.value.email, Profz.value.username, null,  this.pic);
      //this.conn.updateProf(user);
      console.log(this.user);
    }
  }
  

  handleFileInput(file : FileList){
    this.fileToUpload = file.item(0);

    var reader = new FileReader();
    reader.onload = (event:any) => {
      this.user.displayImg = event.target.result;
      console.log(event);
      this.pic = event.target.result;
    }
    reader.readAsDataURL(this.fileToUpload);
  }
}
