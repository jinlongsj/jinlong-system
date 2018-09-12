-- 表30 ：角色菜单关系表 (tbl_jinlong_system_role_menu)
DROP TABLE IF exists tbl_jinlong_system_role_menu;
CREATE TABLE tbl_jinlong_system_role_menu
(
	role_menu_id 	INT(11) 		AUTO_INCREMENT 	COMMENT '角色菜单ID',
	role_id  		INT(11) 		NOT NULL 		COMMENT '角色ID',
	menu_id  		INT(11) 		NOT NULL 		COMMENT '菜单ID',
	PRIMARY KEY 	(role_menu_id)                  -- 设置主键：角色菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;