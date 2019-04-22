CREATE TABLE Users(
    username VARCHAR2(40) PRIMARY KEY,
    password VARCHAR2(40) NOT NULL,
    email VARCHAR2(50),
    display_name VARCHAR2(120),
    display_image_url VARCHAR2(250)
);
SELECT*FROM Users;
DROP TABLE Users;


CREATE TABLE Ratings(
    ratings_ID Number PRIMARY KEY,
    value VARCHAR2(25),
    Post_ID Number,
    username VARCHAR2(40),
    
    CONSTRAINT fk_fkey2 FOREIGN KEY (username) REFERENCES Users (username)
);
ALTER TABLE Ratings ADD CONSTRAINT fk_fkey8 FOREIGN KEY (Post_ID) REFERENCES Posts (Post_ID);
ALTER TABLE Ratings DROP CONSTRAINT fk_fkey2;
ALTER TABLE Ratings DROP CONSTRAINT fk_fkey8;
DROP TABLE Ratings;

CREATE TABLE Posts(
    Post_ID Number PRIMARY KEY,
    Title_Column VARCHAR2(150),
    Image VARCHAR2(150),
    Caption VARCHAR2 (200),
    username VARCHAR2 (40),
    
    CONSTRAINT fk_fkey4 FOREIGN KEY (username) REFERENCES Users (username)
);
INSERT INTO Posts(Post_ID,Title_Column,Image,Caption,username)VALUES(102,'new post','new image', 'new caption','User1');

ALTER TABLE Posts DROP CONSTRAINT fk_fkey4;
ALTER TABLE Posts DROP CONSTRAINT fk_fkey5;
ALTER TABLE Posts DROP CONSTRAINT fk_key6;
ALTER TABLE Posts DROP COLUMN Comment_ID;
ALTER TABLE Posts DROP COLUMN Ratings_ID;
DROP TABLE Posts;
SELECT*FROM Posts;


CREATE TABLE Comments(
    Comment_ID Number PRIMARY KEY,
    Post_ID Number,
    username VARCHAR2(40),
    Message VARCHAR2(400),
    
    CONSTRAINT fk_fkey3 FOREIGN KEY (username) REFERENCES Users (username)   
);


ALTER TABLE Comments ADD CONSTRAINT fk_fkey7 FOREIGN KEY (Post_ID) REFERENCES Posts (Post_ID);
ALTER TABLE Comments DROP CONSTRAINT fk_fkey3;
ALTER TABLE Comments DROP CONSTRAINT fk_fkey7;
DROP TABLE Comments;
