-- 表1 ：文件类型字典表 (dic_jinlong_system_file_type)
DROP TABLE IF exists dic_jinlong_system_file_type;
CREATE TABLE dic_jinlong_system_file_type
(
	value   	INT(11) 		AUTO_INCREMENT 	COMMENT '文件类别ID',
	name	    VARCHAR(20) 	NOT NULL 		COMMENT '父类文件类别ID',
	PRIMARY KEY	(value)                 		-- 设置主键：文件类别ID
)
ENGINE= MYISAM CHARACTER SET utf8;