-- 表20 ：角色流程状态字典表 
drop table if exists dic_jinlong_system_role_process_state;
create table dic_jinlong_system_role_process_state
(
	value			INT(11) 	auto_increment 	comment '角色流程状态ID',
	name			VARCHAR(20) not null 		comment '角色流程状态名称',
	primary key		(value)         			-- 设置主键：角色流程状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;