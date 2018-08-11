-- 表15 ：角色状态字典表 (dic_jinlong_system_role_state)
drop table if exists dic_jinlong_system_role_state;
create table dic_jinlong_system_role_state
(
	value	INT(11) 	auto_increment 	comment '角色状态ID',
	name	VARCHAR(20) not null 		comment '角色状态名称',
	primary key			(value) 		-- 设置主键：角色状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;