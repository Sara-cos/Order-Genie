create table order1(orderId int primary key,orderDate date not null,customerId int,FOREIGN KEY(customerId) REFERENCES Customer(customerId),orderValue double not null,shippingCost double not null,shippingAgency varchar(20) not null,orderStatus varchar(20) not null);
insert into order1 values(1,"2023-09-12",1001,3000,60,"XYZ","Pending");
insert into order1 values(2,"2022-05-24",1002,5000,50,"ABC","Delivered");
insert into order1 values(3,"2022-03-09",1003,7000,80,"RTY","Pending");
insert into order1 values(4,"2023-12-04",1004,9000,0,"PQR","Delivered");
select * from order1;