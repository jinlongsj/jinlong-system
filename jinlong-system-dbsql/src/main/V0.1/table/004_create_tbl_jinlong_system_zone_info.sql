-- 表4 ：（省市县区）地区信息表(tbl_jinlong_system_zone)
drop table if exists tbl_jinlong_system_zone;
create table tbl_jinlong_system_zone
(
	zone_id 	INT(11) 		auto_increment 	comment '地区ID',
	parent_id 	INT(11) 		not null 		comment '地区父类ID',
	zone_name 	VARCHAR(50) 	not null 		comment '地区名称',
	description VARCHAR(1000) 					comment '地区详情',
	primary key (zone_id)      		  			-- 设置主键：地区ID
)
ENGINE= MYISAM CHARACTER SET utf8;