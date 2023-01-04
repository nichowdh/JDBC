USE niladri_db;
#table creation
create table Bank(
account_no bigint primary key,
account_holder varchar(20) not null,
ifsc_code varchar(20) unique not null,
branch varchar(10),
account_type varchar(10),
balance double(12,2) check (balance>1999),
pin numeric(4) unique not null
);

