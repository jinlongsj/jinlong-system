-- 表2 ：文件信息表 (tbl_jinlong_system_file_info)
drop table if exists tbl_jinlong_system_file_info;
create table tbl_jinlong_system_file_info
(
	file_id	    INT(11)     	auto_increment 	comment '文件ID',
	type_id 	INT(11)     		 			comment '文件类型ID',
	user_id		INT(11)     	not null 		comment '提交人ID',
	init_name	VARCHAR(50) 	not null       	comment '文件初始化名称',
	file_name	VARCHAR(50) 	not null 		comment '文件名称',
	file_path	VARCHAR(1000) 	not null 		comment '文件路径',
	submit_time	DATETIME    	not null 		comment '上传时间',
	description	TEXT         					comment '上传文件详情',
	state       INT(1)     			 			comment '上传文件的状态',
	primary key (file_id)                   	-- 设置书剑：文件ID
)
ENGINE= MYISAM CHARACTER SET utf8;