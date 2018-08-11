-- 表21 ：菜单分类类别表 (tbl_jinlong_system_menu_type)
drop table if exists tbl_jinlong_system_menu_type;
create table dic_jinlong_system_menu_type
(
	value		INT(11) 	auto_increment 	comment '菜单分类类别ID',
	name		VARCHAR(20)	not null 		comment '菜单分类类别名称',
	primary key (value)                 	-- 设置主键：菜单分类类别ID
)
ENGINE= MYISAM CHARACTER SET utf8;