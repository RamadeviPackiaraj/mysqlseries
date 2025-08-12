use employee_db;
create table product_details(
id integer primary key auto_increment,
pro_name text not null,
price real);
insert into product_details(pro_name,price) values ('mobile',50000),('labtop',90000),('watch',10000),('ipad',45000);
select *from product_details where price=90000;
select*from product_details where price>50000; 	
select * from product_details where price < 50000;
select *from product_details where price>=50000;
select *from product_details where price<=45000;
select * from product_details where price<>50000;

----------------------------------------------------
select *from product_details where price > ALL (select price from product_details where pro_name='ipad'UNION select price from product_details where pro_name='watch');
select *from product_details where price <50000 AND price >30000;
select * from product_details where price > any (select price from product_details where price>10000);
select * from product_details where price between 10000 and 50000;
create table orders(
id integer primary key auto_increment,
name text);
insert into orders(name) values('fashwash'),('sunscreen'),('lipbalm');
select * from product_details where  exists (select 1 from orders o where o.id = product_details.id);
select * from product_details where price in (select price from product_details where price >10000);
select * from product_details where pro_name like('______'); -- 6 characters
select * from product_details where  NOT pro_name='labtop';
select * from product_details where  pro_name NOT in('labtop','watch');
SELECT * FROM product_details WHERE price NOT BETWEEN 20000 AND 60000;
SELECT * FROM product_details WHERE pro_name NOT LIKE 'm%';
select *from product_details where pro_name='laptob'OR pro_name='mobile'OR price =10000;
SELECT * FROM product_details WHERE price > SOME ( SELECT price FROM product_details WHERE pro_name IN ('watch', 'ipad'));
SELECT * FROM product_details WHERE price < SOME ( SELECT price FROM product_details WHERE pro_name IN ('labtop', 'mobile'));