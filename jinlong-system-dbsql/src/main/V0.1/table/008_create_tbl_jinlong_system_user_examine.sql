-- 表8 ：用户审核信息表
DROP TABLE IF exists tbl_jinlong_system_user_examine;
CREATE TABLE tbl_jinlong_system_user_examine
(
	user_id			INT(11)			NOT NULL	COMMENT	'被审核的用户ID',
	examine_user_id INT(11)			NOT NULL	COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL	COMMENT	'审核流程时间',
	is_pass			TINYINT(1)		NOT NULL	COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL	COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 	COMMENT '用户审核状态',
	PRIMARY KEY		(user_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;