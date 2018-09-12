-- 表3 ：文件状态字典表 (dic_jinlong_system_file_state)
DROP TABLE IF exists dic_jinlong_system_file_state;
CREATE TABLE dic_jinlong_system_file_state
(
	value			INT(11) 		AUTO_INCREMENT 	COMMENT '文件状态ID',
	name			VARCHAR(20) 	NOT NULL 		COMMENT '文件状态名称',
	PRIMARY KEY		(value)         			-- 设置主键：文件状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;