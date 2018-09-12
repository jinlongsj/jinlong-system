-- 表7 ：用户组流程状态字典表 
DROP TABLE IF exists dic_jinlong_system_user_group_process_state;
CREATE TABLE dic_jinlong_system_user_group_process_state
(
	value			INT(11) 	AUTO_INCREMENT 	COMMENT '用户组流程状态ID',
	name			VARCHAR(20) NOT NULL 		COMMENT '用户组流程状态名称',
	PRIMARY KEY		(value)         			-- 设置主键：用户组流程状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;