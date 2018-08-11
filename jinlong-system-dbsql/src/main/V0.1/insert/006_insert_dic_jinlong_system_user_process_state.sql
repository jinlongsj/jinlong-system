-- 初始化表12 ：用户流程字典表数据
insert into dic_jinlong_system_user_process_state (value, name) values (1, '新增用户');
insert into dic_jinlong_system_user_process_state (value, name) values (2, '新增提交审核');
insert into dic_jinlong_system_user_process_state (value, name) values (3, '新增用户审核通过');
insert into dic_jinlong_system_user_process_state (value, name) values (4, '新增用户审核不通过');
insert into dic_jinlong_system_user_process_state (value, name) values (5, '锁定用户提交审核');
insert into dic_jinlong_system_user_process_state (value, name) values (6, '锁定用户审核通过');
insert into dic_jinlong_system_user_process_state (value, name) values (7, '锁定用户审核不通过');
insert into dic_jinlong_system_user_process_state (value, name) values (8, '注销用户提交审核');
insert into dic_jinlong_system_user_process_state (value, name) values (9, '注销用户审核通过');
insert into dic_jinlong_system_user_process_state (value, name) values (10, '注销用户审核不通过');

commit;