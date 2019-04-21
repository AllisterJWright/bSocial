export class Posting {
    Author : string;
    Title: string;
    FileStream : string;
    Description : string;


    constructor (Author: string, Title: string, FileStream: string, Description: string){
        this.Author = Author;
        this.Title = Title;
        this.FileStream = FileStream;
        this.Description = Description;

    }
}