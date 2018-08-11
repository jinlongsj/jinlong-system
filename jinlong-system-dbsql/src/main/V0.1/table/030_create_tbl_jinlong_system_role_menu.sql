-- 表25 ：角色菜单关系表 (tbl_jinlong_system_role_menu)
drop table if exists tbl_jinlong_system_role_menu;
create table tbl_jinlong_system_role_menu
(
	role_menu_id 	INT(11) 		auto_increment 	comment '角色菜单ID',
	role_id  		INT(11) 		not null 		comment '角色ID',
	menu_id  		INT(11) 		not null 		comment '菜单ID',
	primary key 	(role_menu_id)                  -- 设置主键：角色菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;