-- 表27 ：菜单流程表
drop table if exists tbl_jinlong_system_menu_process;
create table tbl_jinlong_system_menu_process
(
	process_id		INT(11)			auto_increment	comment '菜单流程ID',
	menu_id			INT(11)			NOT NULL		comment	'菜单ID',
	record_id		INT(11)			NOT NULL		comment '审核记录信息ID',
	process_time 	DATETIME						comment	'流程节点时间',
	state			INT(1) 	  		NOT NULL 		comment '菜单流程状态',
	primary key		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;