-- 表19 ：角色流程表
DROP TABLE IF exists tbl_jinlong_system_role_process;
CREATE TABLE tbl_jinlong_system_role_process
(
	process_id		INT(11)			AUTO_INCREMENT	COMMENT '角色流程ID',
	role_id			INT(11)			NOT NULL		COMMENT	'角色ID',
	record_id		INT(11)			NOT NULL		COMMENT '审核记录信息ID',
	process_time 	DATETIME						COMMENT	'流程节点时间',
	state			INT(1) 	  		NOT NULL 		COMMENT '角色流程状态',
	PRIMARY KEY		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;