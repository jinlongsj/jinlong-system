-- 表10 ：用户审核记录信息表
drop table if exists tbl_jinlong_system_user_examine_record;
create table tbl_jinlong_system_user_examine_record
(
	examine_id		INT(11)			auto_increment	comment '用户审核记录ID',
	user_id			INT(11)			NOT NULL		comment	'被审核的用户ID',
	examine_user_id INT(11)			NOT NULL		comment '审核人ID',
	examine_time 	DATETIME		NOT NULL		comment	'审核记录时间',
	is_pass			TINYINT(1)		NOT NULL		comment	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL		comment	'审核详情意见',
	state			INT(1) 	  		NOT NULL 		comment '用户审核ss状态',
	primary key		(examine_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;