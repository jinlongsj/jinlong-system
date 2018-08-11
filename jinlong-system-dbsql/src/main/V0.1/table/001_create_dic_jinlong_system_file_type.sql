-- 表1 ：文件类型字典表 (dic_jinlong_system_file_type)
drop table if exists dic_jinlong_system_file_type;
create table dic_jinlong_system_file_type
(
	value   	INT(11) 		auto_increment 	comment '文件类别ID',
	name	    VARCHAR(20) 	not null 		comment '父类文件类别ID',
	primary key	(value)                 		-- 设置主键：文件类别ID
)
ENGINE= MYISAM CHARACTER SET utf8;