export class User{
    name : string;
    email : string;
    password : string;
    username : string;
    displayImg : any;
    
    constructor(name : string, email : string, username : string, password: string, displayImg: any){
        this.name = name;
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