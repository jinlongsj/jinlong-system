-- 表18 ：角色审核记录信息表
DROP TABLE IF exists tbl_jinlong_system_role_examine_record;
CREATE TABLE tbl_jinlong_system_role_examine_record
(
	record_id		INT(11)			AUTO_INCREMENT	COMMENT '角色审核记录ID',
	role_id			INT(11)			NOT NULL		COMMENT	'被审核的角色ID',
	examine_user_id INT(11)			NOT NULL		COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL		COMMENT	'审核记录时间',
	is_pass			TINYINT(1)		NOT NULL		COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL		COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 		COMMENT '角色审核ss状态',
	PRIMARY KEY		(record_id)						-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;