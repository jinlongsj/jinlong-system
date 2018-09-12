-- 表24：菜单状态表 (dic_jinlong_system_menu_state)
drop table if exists dic_jinlong_system_menu_state;
create table dic_jinlong_system_menu_state
(
	value		INT(11) 	AUTO_INCREMENT 	COMMENT '菜单状态ID',
	name		VARCHAR(20) NOT NULL 		COMMENT '菜单状态名称',
	primary key	(value)         			-- 设置主键：菜单状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;