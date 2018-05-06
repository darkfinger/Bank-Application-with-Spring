create table account (account_no bigint not null, account_type varchar(255), balance float, user_id bigint, primary key (account_no)) engine=InnoDB
create table admin (id bigint not null auto_increment, admin_email varchar(255), admin_password varchar(255), last_login datetime, position varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table transactions (id bigint not null, amount float, date_of_transaction datetime, from_account_account_no bigint, to_account_account_no bigint, primary key (id)) engine=InnoDB
create table user (dtype varchar(31) not null, id bigint not null auto_increment, date_of_birth datetime, date_of_subscription datetime, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), pin integer, admin_password varchar(255), position varchar(255), primary key (id)) engine=InnoDB
create table user_address (id bigint not null, city varchar(255), country varchar(255), number varchar(255), street varchar(255), zip_code varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user_contact (id bigint not null, contact_number bigint, type_contact varchar(255), user_id bigint, primary key (id)) engine=InnoDB
alter table account add constraint FK7m8ru44m93ukyb61dfxw0apf6 foreign key (user_id) references user (id)
alter table transactions add constraint FKqy1wp3p35f46a3inxq9b6kbwj foreign key (from_account_account_no) references account (account_no)
alter table transactions add constraint FK67od15qksrmdrlig9p7cyew5a foreign key (to_account_account_no) references account (account_no)
alter table user_address add constraint FKk2ox3w9jm7yd6v1m5f68xibry foreign key (user_id) references user (id)
alter table user_contact add constraint FK9fm1vrfyjcs735xlykhnedyd7 foreign key (user_id) references user (id)
