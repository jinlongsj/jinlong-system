-- 表9 ：用户状态字典表 
DROP TABLE IF exists dic_jinlong_system_user_examine_state;
CREATE TABLE dic_jinlong_system_user_examine_state
(
	value			INT(11) 	AUTO_INCREMENT 	COMMENT '用户状态ID',
	name			VARCHAR(20) NOT NULL 		COMMENT '用户状态名称',
	primary key		(value)         			-- 设置主键：用户状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;