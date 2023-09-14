create table Customer(customerId int primary key,customerName varchar(20) not null,password varchar(20) not null,customerGstNumber varchar(20) not null,
customerAddress varchar(50) not null,
 customerCity varchar(20) not null, email varchar(20) not null,phone long not null,pincode int not null,customerLoginStatus boolean not null);
 insert into Customer values(1001,"shivanshita","shiv123","1234","Renukoot","Renukoot","shivi@gmail.com",2345678901,123456,false);
  insert into Customer values(1002,"shruti","shr234","3456","Moradabad","Moradabad","shr@gmail.com",1678905463,253654,false);
   insert into Customer values(1003,"shakti","shk78","9087","Pune","Pune","sha@gmail.com",7896546376,678543,false);
    insert into Customer values(1004,"ujjwal","ujj34","7685","Kanpur","Kanpur","ujj@gmail.com",6574839205,657483,false);
	