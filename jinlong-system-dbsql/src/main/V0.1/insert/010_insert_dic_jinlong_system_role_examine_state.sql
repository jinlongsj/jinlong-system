-- 初始化表17 ：角色状态审核字典表数据
insert into dic_jinlong_system_role_examine_state (value, name) values (1, '未审核');
insert into dic_jinlong_system_role_examine_state (value, name) values (2, '审核通过');
insert into dic_jinlong_system_role_examine_state (value, name) values (3, '审核未通过');
insert into dic_jinlong_system_role_examine_state (value, name) values (4, '已失效');

commit;