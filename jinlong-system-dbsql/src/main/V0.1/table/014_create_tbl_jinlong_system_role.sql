-- 表14 ：角色信息表(tbl_jinlong_system_role)
drop table if exists tbl_jinlong_system_role;
create table tbl_jinlong_system_role
(
	role_id 		INT(11)		 auto_increment comment '角色ID',
	type_id 		INT(11)		 not null		comment '角色类别',
	role_code 		VARCHAR(50)  not null 		comment '角色编码',
	role_name 		VARCHAR(50)  not null 		comment '角色名称',
	description 	VARCHAR(500)  				comment '角色描述',
	state 			INT(11)		 not null		comment '角色状态',
	proccess_state  INT(11)		 not null		comment '角色流程状态',
	primary key		(role_id) 				    -- 设施主键：角色ID
)
ENGINE= MYISAM CHARACTER SET utf8;