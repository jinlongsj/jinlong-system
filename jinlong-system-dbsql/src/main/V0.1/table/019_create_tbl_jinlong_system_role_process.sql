-- 表19 ：角色流程表
drop table if exists tbl_jinlong_system_role_process;
create table tbl_jinlong_system_role_process
(
	process_id		INT(11)			auto_increment	comment '角色流程ID',
	role_id			INT(11)			NOT NULL		comment	'角色ID',
	record_id		INT(11)			NOT NULL		comment '审核记录信息ID',
	process_time 	DATETIME						comment	'流程节点时间',
	state			INT(1) 	  		NOT NULL 		comment '角色流程状态',
	primary key		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;