-- 表21 ：菜单分类类别表 (tbl_jinlong_system_menu_type)
DROP TABLE IF exists tbl_jinlong_system_menu_type;
CREATE TABLE dic_jinlong_system_menu_type
(
	value		INT(11) 	AUTO_INCREMENT 	COMMENT '菜单分类类别ID',
	name		VARCHAR(20)	NOT NULL 		COMMENT '菜单分类类别名称',
	PRIMARY KEY (value)                 	-- 设置主键：菜单分类类别ID
)
ENGINE= MYISAM CHARACTER SET utf8;