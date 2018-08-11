-- 初始化表20 ：角色流程字典表数据
insert into dic_jinlong_system_role_process_state (value, name) values (1, '新增角色');
insert into dic_jinlong_system_role_process_state (value, name) values (2, '新增角色提交审核');
insert into dic_jinlong_system_role_process_state (value, name) values (3, '新增角色审核通过');
insert into dic_jinlong_system_role_process_state (value, name) values (4, '新增角色审核不通过');
insert into dic_jinlong_system_role_process_state (value, name) values (5, '锁定角色提交审核');
insert into dic_jinlong_system_role_process_state (value, name) values (6, '锁定角色审核通过');
insert into dic_jinlong_system_role_process_state (value, name) values (7, '锁定角色审核不通过');
insert into dic_jinlong_system_role_process_state (value, name) values (8, '注销角色提交审核');
insert into dic_jinlong_system_role_process_state (value, name) values (9, '注销角色审核通过');
insert into dic_jinlong_system_role_process_state (value, name) values (10, '注销角色审核不通过');

commit;