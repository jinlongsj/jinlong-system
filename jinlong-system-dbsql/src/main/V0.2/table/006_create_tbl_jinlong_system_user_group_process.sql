-- 表36 ：用户组流程表
DROP TABLE IF exists tbl_jinlong_system_user_group_process;
CREATE TABLE tbl_jinlong_system_user_group_process
(
	process_id		INT(11)			AUTO_INCREMENT	COMMENT '菜单流程ID',
	user_group_id	INT(11)			NOT NULL		COMMENT	'菜单ID',
	record_id		INT(11)			NOT NULL		COMMENT '审核记录信息ID',
	process_time 	DATETIME						COMMENT	'流程节点时间',
	state			INT(1) 	  		NOT NULL 		COMMENT '菜单流程状态',
	PRIMARY KEY		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;