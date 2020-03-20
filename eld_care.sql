drop database eld_care;
create database eld_care;
use eld_care;
/*用户*/
drop table if exists user;
create table user
(
	ID int auto_increment,
	NAME varchar(50) not null,
	PASSWORD varchar(50) not null,
	TYPE int null,
	GMT_CREATE bigint null,
	GMT_MODIFIED bigint null,
	TOKEN varchar(50) null comment '缓存信息，每次登陆产生',
	constraint user_NAME_uindex
		unique (NAME),
	constraint user_id_uindex
		unique (ID)
);

alter table user
	add primary key (NAME);



/*comment on column T_USER.TYPE is '1、护工；2、家属；3、院方';*/


