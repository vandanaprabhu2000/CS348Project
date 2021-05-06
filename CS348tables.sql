drop database IF EXISTS cs348project;
create database cs348project;
use cs348project; 
-- This table creates the Students for the database
DROP TABLE IF EXISTS Students;
create table Students(student_id int not null AUTO_INCREMENT,
name varchar(255) not null, 
email varchar(255) not null unique, 
Primary Key (student_id));

DROP TABLE IF EXISTS Clubs;
create table Clubs(id int not null AUTO_INCREMENT, 
name varchar(255) not null unique, 
address varchar(200) not null, 
description varchar(200) not null, Primary Key (id));

DROP TABLE IF EXISTS Rooms;
create table Rooms(id int not null AUTO_INCREMENT, 
building varchar(200) not null unique, 
number int not null, 
maxCapacity int not null, primary key (id));

DROP TABLE IF EXISTS Meetings;
create table Meetings(id int not null AUTO_INCREMENT, 
date date not null,
time timestamp not null,
duration int not null,
description varchar(255) not null,
club_id int not null,
room_id int not null,
invitedCount int not null,
acceptedCount int not null,
primary key (id),
foreign key (club_id) references Clubs(id), 
foreign key (room_id) references Rooms(id));

DROP TABLE IF EXISTS MeetingOrganizers;
create table MeetingOrganizers(meeting_id int not null AUTO_INCREMENT, 
student_id int not null,
foreign key (meeting_id) references Meetings(id),
foreign key (student_id) references Students(student_id));

DROP TABLE IF EXISTS RSVP;
create table RSVP(meeting_id int not null AUTO_INCREMENT,
student_id int not null,
invitation_date date not null,
reply_date date not null,
replyType varchar(255) not null,
comment varchar(255) not null,
foreign key (meeting_id) references Meetings(id),
foreign key (student_id) references Students(student_id));

create unique index club_index on clubs(club_id);
create unique index student_index on students(student_id);
create unique index meeting_index on meetings(meeting_id);