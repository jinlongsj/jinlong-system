-- 表5 ：用户基础信息表
drop table if exists tbl_jinlong_system_user_base;
create table tbl_jinlong_system_user_base
(
	user_id		 	INT(11) 	  	auto_increment 	comment '用户ID',
	role_id 	 	INT(11) 	  	not null 	 	comment '所属角色ID ',
	affiliated_id 	INT(11) 	  			 	 	comment '所属角色用户的扩展表ID',
	register_time  	DATETIME 	  	not null 		comment '用户注册时间',
	user_name 	 	VARCHAR(50)  	not null 	 	comment '用户名称',
	password 	 	VARCHAR(100) 	not null 	 	comment '用户密码',
	mobile_phone 	VARCHAR(11)  	not null 	 	comment '用户手机号码',
	email 		 	VARCHAR(500) 			 	 	comment '用户邮箱',
	state 		 	INT(1) 	  		not null 	 	comment '用户状态',
	primary key	 	(user_id)                   	-- 设置主键：用户ID
)
ENGINE=MYISAM CHARACTER SET utf8;