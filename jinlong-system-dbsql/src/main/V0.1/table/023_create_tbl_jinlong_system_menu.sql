-- 表22 ：菜单信息表 (tbl_jinlong_system_menu)
drop table if exists tbl_jinlong_system_menu;
create table tbl_jinlong_system_menu
(
	menu_id 		INT(11) 	  	auto_increment 	comment '菜单ID',
	type_id 		INT(11) 	  	not null 		comment '所属菜单类别ID',
	level_id		INT(11)		  	not null		comment '所属菜单级别',
	parent_id 		INT(11) 	  	not null 		comment '父类菜单ID',
	menu_code 		VARCHAR(50)   	not null 		comment '菜单编码',
	menu_name 		VARCHAR(50)   	not null 		comment '菜单名称',
	menu_url 		VARCHAR(500)  	not null 		comment '菜单URL',
	image 			INT(11)		   					comment '菜单图片文件ID',
	description 	VARCHAR(1000)  					comment '菜单详情描述',
	state 			INT(1) 		  	not null 		comment '菜单状态',
	proccess_state  INT(11)		 	not null		comment '菜单流程状态',
	primary key	(menu_id) 				      		-- 设施主键：菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;