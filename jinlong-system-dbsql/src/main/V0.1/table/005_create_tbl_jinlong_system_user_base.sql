-- 表5 ：用户基础信息表
DROP TABLE IF exists tbl_jinlong_system_user_base;
CREATE TABLE tbl_jinlong_system_user_base
(
	user_id		 	INT(11) 	  	AUTO_INCREMENT 	COMMENT '用户ID',
	role_id 	 	INT(11) 	  	NOT NULL 	 	COMMENT '所属角色ID ',
	affiliated_id 	INT(11) 	  			 	 	COMMENT '所属角色用户的扩展表ID',
	register_time  	DATETIME 	  	NOT NULL 		COMMENT '用户注册时间',
	user_name 	 	VARCHAR(50)  	NOT NULL 	 	COMMENT '用户名称',
	password 	 	VARCHAR(100) 	NOT NULL 	 	COMMENT '用户密码',
	mobile_phone 	VARCHAR(11)  	NOT NULL 	 	COMMENT '用户手机号码',
	email 		 	VARCHAR(500) 			 	 	COMMENT '用户邮箱',
	state 		 	INT(1) 	  		NOT NULL 	 	COMMENT '用户状态',
	primary key	 	(user_id)                   	-- 设置主键：用户ID
)
ENGINE=MYISAM CHARACTER SET utf8;