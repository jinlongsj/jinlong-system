-- 表22 ：菜单级别表 (tbl_jinlong_system_menu_leval)
drop table if exists tbl_jinlong_system_menu_leval;
create table dic_jinlong_system_menu_leval
(
	value		INT(11) 	auto_increment 	comment '菜单级别ID',
	name		VARCHAR(20)	not null 		comment '菜单级别名称',
	primary key (value)                 	-- 设置主键：菜单级别ID
)
ENGINE= MYISAM CHARACTER SET utf8;