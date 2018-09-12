-- 表16 ：角色审核信息表
DROP TABLE IF exists tbl_jinlong_system_role_examine;
CREATE TABLE tbl_jinlong_system_role_examine
(
	role_id			INT(11)			NOT NULL	COMMENT	'被审核的角色ID',
	examine_user_id INT(11)			NOT NULL	COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL	COMMENT	'审核流程时间',
	is_pass			TINYINT(1)		NOT NULL	COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL	COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 	COMMENT '角色审核状态',
	PRIMARY KEY		(role_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;