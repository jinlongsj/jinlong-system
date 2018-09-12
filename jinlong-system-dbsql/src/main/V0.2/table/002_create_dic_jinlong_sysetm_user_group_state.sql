-- 表32：用户组状态表 (dic_jinlong_system_user_group_state)
DROP TABLE IF exists dic_jinlong_system_user_group_state;
CREATE TABLE dic_jinlong_system_user_group_state
(
	value		INT(11) 	AUTO_INCREMENT 	COMMENT '用户组状态表ID',
	name		VARCHAR(20) NOT NULL 		COMMENT '用户组状态表名称',
	PRIMARY KEY	(value)         			-- 设置主键：用户组状态表状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;