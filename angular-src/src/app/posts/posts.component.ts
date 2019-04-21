import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect.service';
import { Posting } from '../Posting';
import { User } from '../User';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  IUrl : string = '../../assets/Bee2.png';
  fileToUpload : File = null;
  NewPost : Posting;
  user : User;
  pic : string;



  constructor(private conn : ConnectService) { }

  ngOnInit() {
    
  }

  UPost(Poatz: any){
    this.NewPost = new Posting("temp", Poatz.value.Title, Poatz.value.FileStream, Poatz.value.Description);
    console.log(Poatz);
    console.log(this.NewPost);
    /*
    this.conn.insertPost(this.NewPost).subscribe(
      data =>  {
        console.log(data);
      },
      error => {
        alert("Error");
      }
    )
    */
    /*
    this.conn.insertPost(user ,NewPost).Subscribe(
      data =>  {
        console.log(data);
      },
      error => {
        alert("Error");
      }
    )
   */
  }


  handleFileInput(file : FileList){
    this.fileToUpload = file.item(0);

    var reader = new FileReader();
    reader.onload = (event:any) => {
      this.IUrl = event.target.result;
      this.pic =  event.target.result;
    }
    reader.readAsDataURL(this.fileToUpload);
  }

}
