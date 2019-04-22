export class User{
    displayName : string;
    email : string;
    password : string;
    username : string;
    displayImg : any;
    
    constructor(displayName : string, email : string, username : string, password: string, displayImg: any){
        this.displayName = displayName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.displayImg = displayImg;
    }

    /*
    firstName : string;
    lastName : string;
    email : string;
    username : string;
    password : string;
    
    constructor(firstName : string, lastName : string, email : string, username : string, password : string){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    */

}