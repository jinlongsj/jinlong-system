-- 表35 ：用户组审核记录信息表
DROP TABLE IF exists tbl_jinlong_system_user_group_examine_record;
CREATE TABLE tbl_jinlong_system_user_group_examine_record
(
	record_id		INT(11)			AUTO_INCREMENT	COMMENT '用户组审核记录ID',
	user_group_id	INT(11)			NOT NULL		COMMENT	'被审核的用户组ID',
	examine_user_id INT(11)			NOT NULL		COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL		COMMENT	'审核记录时间',
	is_pass			TINYINT(1)		NOT NULL		COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL		COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 		COMMENT '用户组审核ss状态',
	primary key		(record_id)						-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;