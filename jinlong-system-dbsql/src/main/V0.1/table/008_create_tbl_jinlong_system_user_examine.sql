-- 表8 ：用户审核信息表
drop table if exists tbl_jinlong_system_user_examine;
create table tbl_jinlong_system_user_examine
(
	user_id			INT(11)			NOT NULL	comment	'被审核的用户ID',
	examine_user_id INT(11)			NOT NULL	comment '审核人ID',
	examine_time 	DATETIME		NOT NULL	comment	'审核流程时间',
	is_pass			TINYINT(1)		NOT NULL	comment	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL	comment	'审核详情意见',
	state			INT(1) 	  		NOT NULL 	comment '用户审核状态',
	primary key		(user_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;