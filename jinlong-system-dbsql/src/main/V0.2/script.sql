-- table

-- 表31 ：用户组信息表 (tbl_jinlong_system_user_group)
DROP TABLE IF exists tbl_jinlong_system_user_group;
CREATE TABLE tbl_jinlong_system_user_group
(
	user_group_id 	INT(11) 		AUTO_INCREMENT 	COMMENT '用户组ID',
	parent_id  		INT(11) 		NOT NULL 		COMMENT '用户父ID',
	user_group_name INT(11) 		NOT NULL 		COMMENT '用户组名称',
	create_timne	DATETIME		NOT NULL		COMMENT '创建时间',
	description		VARCHAR(500)	NOT NULL		COMMENT '描述',
	state 			INT(1) 		  	NOT NULL 		COMMENT '用户组状态',
	proccess_state  INT(11)		 	NOT NULL		COMMENT '用户组流程状态',
	PRIMARY KEY 	(user_group_id)                 -- 设置主键：角色菜单ID
)
ENGINE= MYISAM CHARACTER SET utf8;

-- 表32：用户组状态表 (dic_jinlong_system_user_group_state)
DROP TABLE IF exists dic_jinlong_system_user_group_state;
CREATE TABLE dic_jinlong_system_user_group_state
(
	value		INT(11) 	AUTO_INCREMENT 	COMMENT '用户组状态表ID',
	name		VARCHAR(20) NOT NULL 		COMMENT '用户组状态表名称',
	PRIMARY KEY	(value)         			-- 设置主键：用户组状态表状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;

-- 表33 ：用户组审核信息表
DROP TABLE IF exists tbl_jinlong_system_user_group_examine;
CREATE TABLE tbl_jinlong_system_user_group_examine
(
	user_group_id	INT(11)			NOT NULL	COMMENT	'被审核的用户组ID',
	examine_user_id INT(11)			NOT NULL	COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL	COMMENT	'审核流程时间',
	is_pass			TINYINT(1)		NOT NULL	COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL	COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 	COMMENT '菜单审核状态',
	PRIMARY KEY		(user_group_id)				-- 设置主键
)
ENGINE= MYISAM CHARACTER SET utf8;

-- 表34 ：用户组审核状态字典表 
DROP TABLE IF exists dic_jinlong_system_user_group_examine_state;
CREATE TABLE dic_jinlong_system_user_group_examine_state
(
	value			INT(11) 	AUTO_INCREMENT 	COMMENT '菜单审核状态ID',
	name			VARCHAR(20) NOT NULL 		COMMENT '菜单审核状态名称',
	primary key		(value)         			-- 设置主键：菜单审核状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;

-- 表35 ：用户组审核记录信息表
DROP TABLE IF exists tbl_jinlong_system_user_group_examine_record;
CREATE TABLE tbl_jinlong_system_user_group_examine_record
(
	record_id		INT(11)			AUTO_INCREMENT	COMMENT '用户组审核记录ID',
	user_group_id	INT(11)			NOT NULL		COMMENT	'被审核的用户组ID',
	examine_user_id INT(11)			NOT NULL		COMMENT '审核人ID',
	examine_time 	DATETIME		NOT NULL		COMMENT	'审核记录时间',
	is_pass			TINYINT(1)		NOT NULL		COMMENT	'是否通过审核',
	description		VARCHAR(1000)	NOT NULL		COMMENT	'审核详情意见',
	state			INT(1) 	  		NOT NULL 		COMMENT '用户组审核ss状态',
	primary key		(record_id)						-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;

-- 表36 ：用户组流程表
DROP TABLE IF exists tbl_jinlong_system_user_group_process;
CREATE TABLE tbl_jinlong_system_user_group_process
(
	process_id		INT(11)			AUTO_INCREMENT	COMMENT '菜单流程ID',
	user_group_id	INT(11)			NOT NULL		COMMENT	'菜单ID',
	record_id		INT(11)			NOT NULL		COMMENT '审核记录信息ID',
	process_time 	DATETIME						COMMENT	'流程节点时间',
	state			INT(1) 	  		NOT NULL 		COMMENT '菜单流程状态',
	PRIMARY KEY		(process_id)					-- 设置主键
)
ENGINE=MYISAM CHARACTER SET utf8;

-- 表37 ：用户组流程状态字典表 
DROP TABLE IF exists dic_jinlong_system_user_group_process_state;
CREATE TABLE dic_jinlong_system_user_group_process_state
(
	value			INT(11) 	AUTO_INCREMENT 	COMMENT '用户组流程状态ID',
	name			VARCHAR(20) NOT NULL 		COMMENT '用户组流程状态名称',
	PRIMARY KEY		(value)         			-- 设置主键：用户组流程状态ID
)
ENGINE= MYISAM CHARACTER SET utf8;



-- insert

-- 初始化表31 ：用户状态字典表数据
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (1, '未激活');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (2, '已激活');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (3, '锁定用户');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (4, '注销用户');

-- 初始化表2 ：用户审核状态字典表数据
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (1, '未审核');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (2, '审核通过');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (3, '审核未通过');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (4, '已失效');

-- 初始化表37 ：用户流程字典表数据
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (1, '新增用户组');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (2, '新增用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (3, '新增用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (4, '新增用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (5, '修改用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (6, '修改用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (7, '修改用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (8, '锁定用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (9, '锁定用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (10, '锁定用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (11, '删除用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (12, '删除用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (13, '删除用户组审核不通过');

COMMIT;