-- 表6 ：用户状态字典表 
drop table if exists dic_jinlong_system_user_state;
create table dic_jinlong_system_user_state
(
	value			INT(11) 	auto_increment 	comment '用户状态ID',
	name			VARCHAR(20) not null 		comment '用户状态名称',
	primary key		(value)         			-- 设置主键：用户状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;