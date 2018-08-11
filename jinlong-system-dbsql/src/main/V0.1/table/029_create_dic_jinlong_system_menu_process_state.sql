-- 表28 ：菜单流程状态字典表 
drop table if exists dic_jinlong_system_menu_process_state;
create table dic_jinlong_system_menu_process_state
(
	value			INT(11) 	auto_increment 	comment '菜单流程状态ID',
	name			VARCHAR(20) not null 		comment '菜单流程状态名称',
	primary key		(value)         			-- 设置主键：菜单流程状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;