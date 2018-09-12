-- 表14 ：角色信息表(tbl_jinlong_system_role)
DROP TABLE IF exists tbl_jinlong_system_role;
CREATE TABLE tbl_jinlong_system_role
(
	role_id 		INT(11)		 AUTO_INCREMENT COMMENT '角色ID',
	type_id 		INT(11)		 NOT NULL		COMMENT '角色类别',
	role_code 		VARCHAR(50)  NOT NULL 		COMMENT '角色编码',
	role_name 		VARCHAR(50)  NOT NULL 		COMMENT '角色名称',
	description 	VARCHAR(500)  				COMMENT '角色描述',
	state 			INT(11)		 NOT NULL		COMMENT '角色状态',
	proccess_state  INT(11)		 NOT NULL		COMMENT '角色流程状态',
	primary key		(role_id) 				    -- 设施主键：角色ID
)
ENGINE= MYISAM CHARACTER SET utf8;