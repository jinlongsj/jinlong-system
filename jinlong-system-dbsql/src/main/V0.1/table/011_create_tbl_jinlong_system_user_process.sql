-- 表11 ：用户流程表
drop table if exists tbl_jinlong_system_user_process;
create table tbl_jinlong_system_user_process
(
	process_id		INT(11)			auto_increment	comment '用户流程ID',
	user_id			INT(11)			NOT NULL		comment	'用户ID',
	process_time 	DATETIME		NOT NULL		comment	'流程节点时间',
	examine_id		INT(11)							comment '审核信息ID',
	state			INT(2) 	  		NOT NULL		comment '用户流程状态',
	primary key		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;