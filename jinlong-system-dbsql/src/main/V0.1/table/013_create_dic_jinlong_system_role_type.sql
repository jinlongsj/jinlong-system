-- 表13 ：角色分类类别字典表 (dic_jinlong_system_role_type)
drop table if exists dic_jinlong_system_role_type;
create table dic_jinlong_system_role_type
(
	value   	INT(11) 		auto_increment 	comment '文件类别ID',
	name	    VARCHAR(20)		not null 		comment '父类文件类别ID',
	primary key	(value)                 		-- 设置主键：文件类别ID
)
ENGINE= MYISAM CHARACTER SET utf8;