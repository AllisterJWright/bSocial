import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class ConnectService {

  URL = 'http://localhost:8080/bSocial';
  


  // Register a user by sending a user object to be parsed by the middle end.
  registerUser(User){
    return this._http.post<any>(this.URL + '/register', User)
  }

  // To be finished
  loginUser(ULog : any){
    console.log(ULog);
    return this._http.post<any>(this.URL + '/Login.rev', ULog)
  }

  // pull post to be used
  showPost(user : any){
    return this._http.get(this.URL + '/getemployees', user)
  }

  showUserPost(){
    '/autoAddUserPosts.rev'
  }

  //TBI
  insertPost(Post){
    return this._http.post<any>(this.URL + '/submitPost', Post)
  }

  //TBI
  updateProf(){

  }

  //TBI
  forgotPass(Email : String){
    console.log(Email);
    return this._http.post<any>(this.URL + '', Email);

  }

  constructor(private _http: HttpClient) { }
}
