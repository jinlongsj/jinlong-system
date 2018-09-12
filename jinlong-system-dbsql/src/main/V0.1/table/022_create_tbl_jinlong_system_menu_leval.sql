-- 表22 ：菜单级别表 (tbl_jinlong_system_menu_leval)
DROP TABLE IF exists tbl_jinlong_system_menu_leval;
CREATE TABLE dic_jinlong_system_menu_leval
(
	value		INT(11) 	AUTO_INCREMENT 	COMMENT '菜单级别ID',
	name		VARCHAR(20)	NOT NULL 		COMMENT '菜单级别名称',
	PRIMARY KEY (value)                 	-- 设置主键：菜单级别ID
)
ENGINE= MYISAM CHARACTER SET utf8;