-- 表23 ：菜单信息表 (tbl_jinlong_system_menu)
DROP TABLE IF exists tbl_jinlong_system_menu;
CREATE TABLE tbl_jinlong_system_menu
(
	menu_id 		INT(11) 	  	AUTO_INCREMENT 	COMMENT '菜单ID',
	type_id 		INT(11) 	  	NOT NULL 		COMMENT '所属菜单类别ID',
	level_id		INT(11)		  	NOT NULL		COMMENT '所属菜单级别',
	parent_id 		INT(11) 	  	NOT NULL 		COMMENT '父类菜单ID',
	menu_code 		VARCHAR(50)   	NOT NULL 		COMMENT '菜单编码',
	menu_name 		VARCHAR(50)   	NOT NULL 		COMMENT '菜单名称',
	menu_url 		VARCHAR(500)  	NOT NULL 		COMMENT '菜单URL',
	image 			INT(11)		   					COMMENT '菜单图片文件ID',
	description 	VARCHAR(1000)  					COMMENT '菜单详情描述',
	state 			INT(1) 		  	NOT NULL 		COMMENT '菜单状态',
	proccess_state  INT(11)		 	NOT NULL		COMMENT '菜单流程状态',
	primary key	(menu_id) 				      		-- 设施主键：菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;