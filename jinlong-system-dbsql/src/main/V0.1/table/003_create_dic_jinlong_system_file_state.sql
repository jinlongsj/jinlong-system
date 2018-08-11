-- 表3 ：文件状态字典表 (dic_jinlong_system_file_state)
drop table if exists dic_jinlong_system_file_state;
create table dic_jinlong_system_file_state
(
	value			INT(11) 		auto_increment 	comment '文件状态ID',
	name			VARCHAR(20) 	not null 		comment '文件状态名称',
	primary key		(value)         			-- 设置主键：文件状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;