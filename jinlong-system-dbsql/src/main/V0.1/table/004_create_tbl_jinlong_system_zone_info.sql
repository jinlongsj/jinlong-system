-- 表4 ：（省市县区）地区信息表(tbl_jinlong_system_zone)
DROP TABLE IF exists tbl_jinlong_system_zone;
CREATE TABLE tbl_jinlong_system_zone
(
	zone_id 	INT(11) 		AUTO_INCREMENT 	COMMENT '地区ID',
	parent_id 	INT(11) 		NOT NULL 		COMMENT '地区父类ID',
	zone_name 	VARCHAR(50) 	NOT NULL 		COMMENT '地区名称',
	description VARCHAR(1000) 					COMMENT '地区详情',
	PRIMARY KEY (zone_id)      		  			-- 设置主键：地区ID
)
ENGINE= MYISAM CHARACTER SET utf8;