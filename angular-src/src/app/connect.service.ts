import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ConnectService {

  URL = 'http://localhost:8080/bSocial';
  

  // USERS -----------------------------------------------------------------
  // Register a user by sending a user object to be parsed by the middle end.
  registerUser(User){
    return this._http.post<any>(this.URL + '/register', User)
  }

  // To be finished
  loginUser(ULog : any){
    console.log(ULog);
    return this._http.post<any>(this.URL + '/Login.rev', ULog)
  }

  //Sending changes for updating profile
  updateProf(){

  }

  //Collecting all users for a search
  callingAllUsers(user : string){
    return this._http.post<any>(this.URL + '',null);
  }

  //Send and email back for changing password
  forgotPass(Email : String){
    console.log(Email);
    return this._http.post<any>(this.URL + '', Email);
  }
  



  // POSTS --------------------------------------------------------------------
  // pull post to be used
  showPost(user : any){
    return this._http.get(this.URL + '/getemployees', user)
  }

  //Send Post to be inserted
  insertPost(Post){
    return this._http.post<any>(this.URL + '/submitPost', Post)
  }



  constructor(private _http: HttpClient) { }
}
