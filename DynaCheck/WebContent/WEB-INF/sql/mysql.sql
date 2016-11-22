create database CheckSystem character set 'utf8' COLLATE 'utf8_general_ci';

use CheckSystem;
/*
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
	"WEB主机","50%|25%",
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

/*create table dc_system(
	id integer primary key AUTO_INCREMENT,
	appColumn varchar(30),
	appRow varchar(30),
	dataColumn varchar(30),
	dataRow varchar(30)
)engine=innodb default charset=utf8;

create table dc_business(
	id integer primary key AUTO_INCREMENT,
	capColumn varchar(30),
	capRow varchar(30),
	amountColumn varchar(30),
	amountRow varchar(30),
	workColumn varchar(30),
	workRow varchar(30)
)engine=innodb default charset=utf8;
*/
/*create table sapp(
	id integer primary key AUTO_INCREMENT,
	sapp varchar(30)
)engine=innodb default charset=utf8;
create table sdata(
	id integer primary key AUTO_INCREMENT,
	sdata varchar(30)
)engine=innodb default charset=utf8;
*/
alter table appSource drop cpuvalue,
	drop memoryvalue,
	drop diskiovalue,
	drop storagevalue,
	drop messagevalue;

create table dataSource(
	id integer primary key AUTO_INCREMENT,
	columnname varchar(30)
)engine=innodb default charset=utf8;

create table appSource(
	id integer primary key AUTO_INCREMENT,
	columnname varchar(30)
)engine=innodb default charset=utf8;

insert into dataSource(columnname)values('a'),('b'),('c'),('w哈哈'),('d'),('e'),('f');

*/
create table dc(
	id integer primary key AUTO_INCREMENT,
	columnname varchar(30),
	dctype varchar(25),
	tabletype varchar(25)
)engine=innodb default charset=utf8;

insert into dc(columnname,dctype,tabletype)values
	("cp1","system","appsource"),
	("cp2","system","datasource"),
	("cp3","biz","property"),
	("cp4","biz","amount"),
	("cp5","biz","work");
	
select * from dc where dctype="system" and tabletype="appsource" and id="1";