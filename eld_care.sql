drop database eld_care;
create database eld_care;
use eld_care;
/*用户*/
drop table if exists T_USER;
create table T_USER
(
	ID VARCHAR(50) not null,
	PASSWORD VARCHAR(50) not null,
	TYPE INT,
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint T_USER_PK
		primary key (ID)
);

/*comment on column T_USER.TYPE is '1、护工；2、家属；3、院方';*/

create unique index T_USER_ID_UINDEX
	on T_USER (ID);

