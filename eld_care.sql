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

/*comment on column T_USER.TYPE is '1、院方；2、护工；3、家属';*/

create table manager
(
	ID int not null comment '等同于用户id',
	NAME varchar(50) null,
	TELEPHONE varchar(50) null,
	ADDRESS varchar(50) null,
	GMT_MODIFY bigint null,
	constraint manager_id_uindex
		unique (ID)
);

alter table manager
	add primary key (ID);

create table nurse
(
	ID int not null,
	`IN` int null comment '所属养老院id',
	NAME VARCHAR(50) null,
	TELEPHONE VARCHAR(50) null,
	WORK_AGE int null,
	GMT_MODIFY BIGINT null
);

create unique index nurse_ID_uindex
	on nurse (ID);

alter table nurse
	add constraint nurse_pk
		primary key (ID);

create table elder
(
	ID int not null
		primary key,
	`IN` int null comment '所属护工id
',
	NAME varchar(50) null,
	AGE int null,
	GMT_MODIFIED bigint null
);

create table broadcast
(
	ID int auto_increment
		primary key,
	CREATOR int null,
	TITLE varchar(255) null,
	CONTENT varchar(255) null,
	GMT_CREATE bigint null,
	TYPE int null comment '1：老人家属；2：护工；3：全体'
);

create table feedback
(
	ID int auto_increment
		primary key,
	ELDER int null,
	NURSE int null,
	SCORE int null,
	CONTENT varchar(255) null,
	GMT_CREATE bigint null
);

create table health
(
	ID int auto_increment
		primary key,
	NURSE int null,
	ELDER int null,
	IS_ABNORMAL tinyint(1) default 0 null,
	CONTENT varchar(255) null,
	GMT_CREATE bigint null
);








