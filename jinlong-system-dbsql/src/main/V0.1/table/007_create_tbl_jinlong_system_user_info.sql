-- 表7 ：用户主信息表
drop table if exists tbl_jinlong_system_user_info;
create table tbl_jinlong_system_user_info
(
	user_id 	 		INT(11) 	 not null		comment '用户ID',
	real_name 	 		VARCHAR(20)   				comment '真实名字',
	nick_name 	 		VARCHAR(20)   				comment '昵称',
	gender				INT(1)						comment '性别',
	age					INT(3)						comment '年龄',
	id_number			VARCHAR(20)					comment '身份证号码',
	telephone 	 		VARCHAR(13)   				comment '座机电话号码',
	zone_id 	 		INT(11) 	  not null	 	comment '所属地区ID',
	address 	 		VARCHAR(500)  not null 		comment '用户地址',
	post_code 	 		VARCHAR(6)    				comment '用户邮编地址',
	home_page			VARCHAR(500)  		 		comment '个人主页',
	qq_number			VARCHAR(20)    		 		comment '个人QQ',
	ali_pay				VARCHAR(50)   		 		comment '个人淘宝账号',
	image 				VARCHAR(500)  default 0 	comment '头像图片文件ID',
	description  		text          				comment '用户详情描述',
	state 		 		INT(2) 	  		not null 	comment '用户状态',
	primary key	 		(user_id) 				    -- 设施主键：用户ID
)
ENGINE= MYISAM CHARACTER SET utf8;