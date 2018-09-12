-- 表31 ：用户组信息表 (tbl_jinlong_system_user_group)
DROP TABLE IF exists tbl_jinlong_system_user_group;
CREATE TABLE tbl_jinlong_system_user_group
(
	user_group_id 	INT(11) 		AUTO_INCREMENT 	COMMENT '用户组ID',
	parent_id  		INT(11) 		NOT NULL 		COMMENT '用户父ID',
	user_group_name INT(11) 		NOT NULL 		COMMENT '用户组名称',
	create_timne	DATETIMNE		NOT NULL		COMMENT '创建时间',
	description		VARCHAR(500)	NOT NULL		COMMENT '描述',
	state 			INT(1) 		  	NOT NULL 		COMMENT '用户组状态',
	proccess_state  INT(11)		 	NOT NULL		COMMENT '用户组流程状态',
	PRIMARY KEY 	(user_group_id)                 -- 设置主键：角色菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;