-- 表18 ：角色审核记录信息表
drop table if exists tbl_jinlong_system_role_examine_record;
create table tbl_jinlong_system_role_examine_record
(
	record_id		INT(11)			auto_increment	comment '角色审核记录ID',
	role_id			INT(11)			NOT NULL		comment	'被审核的角色ID',
	examine_user_id INT(11)			NOT NULL		comment '审核人ID',
	examine_time 	DATETIME		NOT NULL		comment	'审核记录时间',
	is_pass			TINYINT(1)		NOT NULL		comment	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL		comment	'审核详情意见',
	state			INT(1) 	  		NOT NULL 		comment '角色审核ss状态',
	primary key		(record_id)						-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;