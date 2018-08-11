-- 初始化表3 ：文件状态字典表的数据
insert into dic_jinlong_system_file_state(value, name) value(1, '未审核');
insert into dic_jinlong_system_file_state(value, name) value(2, '审核通过');
insert into dic_jinlong_system_file_state(value, name) value(3, '审核未通过');
insert into dic_jinlong_system_file_state(value, name) value(4, '已停用');

commit;