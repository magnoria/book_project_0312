drop database if exists bookintelly;

create database bookintelly;

use bookintelly;

create table bookinsert(
	ino int auto_increment,
    pwd varchar(20) not null,
	title varchar(13),
    writer varchar(15),
    intro longtext,

constraint primary key (ino)
);

create table bookReview(
	
	rno int auto_increment,
    latter longtext,
    pwd varchar(20) not null,
    ino int,
    constraint primary key(rno),
    constraint bookreview foreign key(ino) references bookinsert(ino) on delete cascade

);
