-- 表11 ：用户流程表
DROP TABLE IF exists tbl_jinlong_system_user_process;
CREATE TABLE tbl_jinlong_system_user_process
(
	process_id		INT(11)			AUTO_INCREMENT	COMMENT '用户流程ID',
	user_id			INT(11)			NOT NULL		COMMENT	'用户ID',
	process_time 	DATETIME		NOT NULL		COMMENT	'流程节点时间',
	examine_id		INT(11)							COMMENT '审核信息ID',
	state			INT(2) 	  		NOT NULL		COMMENT '用户流程状态',
	PRIMARY KEY		(process_id)					-- 设置主键
)
ENGINE= MYISAM CHARACTER SET utf8;