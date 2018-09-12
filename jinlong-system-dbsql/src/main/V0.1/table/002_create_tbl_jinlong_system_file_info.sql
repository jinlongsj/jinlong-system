-- 表2 ：文件信息表 (tbl_jinlong_system_file_info)
DROP TABLE IF exists tbl_jinlong_system_file_info;
CREATE TABLE tbl_jinlong_system_file_info
(
	file_id	    INT(11)     	AUTO_INCREMENT 	COMMENT '文件ID',
	type_id 	INT(11)     		 			COMMENT '文件类型ID',
	user_id		INT(11)     	NOT NULL 		COMMENT '提交人ID',
	init_name	VARCHAR(50) 	NOT NULL       	COMMENT '文件初始化名称',
	file_name	VARCHAR(50) 	NOT NULL 		COMMENT '文件名称',
	file_path	VARCHAR(1000) 	NOT NULL 		COMMENT '文件路径',
	submit_time	DATETIME    	NOT NULL 		COMMENT '上传时间',
	description	TEXT         					COMMENT '上传文件详情',
	state       INT(1)     			 			COMMENT '上传文件的状态',
	PRIMARY KEY (file_id)                   	-- 设置书剑：文件ID
)
ENGINE= MYISAM CHARACTER SET utf8;