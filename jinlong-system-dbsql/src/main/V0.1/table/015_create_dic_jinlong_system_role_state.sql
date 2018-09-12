-- 表15 ：角色状态字典表 (dic_jinlong_system_role_state)
DROP TABLE IF exists dic_jinlong_system_role_state;
CREATE TABLE dic_jinlong_system_role_state
(
	value	INT(11) 	AUTO_INCREMENT 	COMMENT '角色状态ID',
	name	VARCHAR(20) NOT NULL 		COMMENT '角色状态名称',
	PRIMARY KEY			(value) 		-- 设置主键：角色状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;