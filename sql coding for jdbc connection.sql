create database loanmanagement;
use loanmanagement;
drop database loanmanagement;
create table Customer(
CustomerID int primary key,
Name varchar(255),
EmailAddress varchar(255),
phoneNumber varchar(255),
Address varchar(255),
creditscore int);
set foreign_key_checks=0;
create table Loan(
LoanId int primary key,
CustomerID int,
foreign key(CustomerID) references Customer(CustomerID) on delete cascade,

principalAmount long,
interestrate decimal(10,2),
loanterm int,
loantype varchar(255),
loanStatus varchar(255)
);
set foreign_key_checks=0;
select * from Customer;
select * from loan;


insert into Customer values(1,"maheswari","abc@gmail.com","9098765432","chennai",1000),
(2,"malavika","dbc@gmail.com","9098765431","chennai",500),
(3,"saravana","hbc@gmail.com","9098767432","mumbai",390);

insert into Loan values(1,1,100,2.5,2,"carLoan","pending"),
(2,2,600,3.5,3,"HomeLoan","pending"),
(3,3,400,1.5,2,"carLoan","pending");

-- update Loan set loanStatus="approved" where CustomerID in(select CustomerID from Customer where creditscore>650);

-- select count(loanId) from Loan where principalAmount>200;
select principalAmount,interestrate,Loanterm from Loan where loanId=2;
select c.creditscore from Customer c join Loan l on l.CustomerID=c.CustomerID where loanid=2;
update loan set loanstatus="approved" where loanid=2;
select principalAmount,interestrate,loanterm from Loan where LoanId=2;
select principalamount,interestrate,loanterm from Loan where LoanId=3;
select * from Loan;
select * from Loan where loanId=1;
select c.creditscore from Customer c
join Loan l
on l.CustomerID=c.CustomerID
where loanid=1;
update loan set loanstatus="approved" where loanid=1;









