create table student(studentId int not null primary key, name varchar (20), age int, grade varchar(5), courseId varchar(10) not null);

alter table student
add foreign key(courseId) references course(courseId);