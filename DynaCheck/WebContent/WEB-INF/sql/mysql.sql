create database CheckSystem character set 'utf8' COLLATE 'utf8_general_ci';

use CheckSystem;

create table appSource(
	id integer primary key AUTO_INCREMENT,
	cpuname varchar(25),
	cpuvalue varchar(25),
	memoryvalue varchar(25),
	diskiovalue varchar(30),
	storagevalue varchar(25),
	messagevalue varchar(30)
)engine=innodb default charset=utf8;

insert into appSource(
	cpuname,cpuvalue,
	memoryvalue,diskiovalue,
	storagevalue,messagevalue
	)values (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	);
	
alter table appSource change appSource cpuname varchar(25) character utf8;
alter table appsource modify column cpuname varchar(40) character set utf8;
	
alter table appSource drop column cpuname;

insert into appSource(
	cpuname,cpuvalue,
	memoryvalue,diskiovalue,
	storagevalue,messagevalue
	)values(
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	), (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	), (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	), (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	), (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	), (
	"WEB","50%|25%",
	"80%|65%","100MB/s|10MB/s",
	"85%|68%","10000|4500"
	);
	