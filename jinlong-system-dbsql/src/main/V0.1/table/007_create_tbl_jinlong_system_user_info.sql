-- 表7 ：用户主信息表
DROP TABLE IF exists tbl_jinlong_system_user_info;
CREATE TABLE tbl_jinlong_system_user_info
(
	user_id 	 		INT(11) 	 NOT NULL		COMMENT '用户ID',
	real_name 	 		VARCHAR(20)   				COMMENT '真实名字',
	nick_name 	 		VARCHAR(20)   				COMMENT '昵称',
	gender				INT(1)						COMMENT '性别',
	age					INT(3)						COMMENT '年龄',
	id_number			VARCHAR(20)					COMMENT '身份证号码',
	telephone 	 		VARCHAR(13)   				COMMENT '座机电话号码',
	zone_id 	 		INT(11) 	  NOT NULL	 	COMMENT '所属地区ID',
	address 	 		VARCHAR(500)  NOT NULL 		COMMENT '用户地址',
	post_code 	 		VARCHAR(6)    				COMMENT '用户邮编地址',
	home_page			VARCHAR(500)  		 		COMMENT '个人主页',
	qq_number			VARCHAR(20)    		 		COMMENT '个人QQ',
	ali_pay				VARCHAR(50)   		 		COMMENT '个人淘宝账号',
	image 				VARCHAR(500)  DEFAULT 0 	COMMENT '头像图片文件ID',
	description  		text          				COMMENT '用户详情描述',
	state 		 		INT(2)		  NOT NULL 		COMMENT '用户状态',
	primary key	 		(user_id) 				    -- 设施主键：用户ID
)
ENGINE= MYISAM CHARACTER SET utf8;