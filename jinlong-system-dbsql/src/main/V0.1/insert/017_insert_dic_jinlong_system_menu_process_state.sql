-- 初始化表28 ：菜单流程字典表数据
insert into dic_jinlong_system_menu_process_state (value, name) values (1, '新增菜单');
insert into dic_jinlong_system_menu_process_state (value, name) values (2, '新增菜单提交审核');
insert into dic_jinlong_system_menu_process_state (value, name) values (3, '新增菜单审核通过');
insert into dic_jinlong_system_menu_process_state (value, name) values (4, '新增菜单审核不通过');
insert into dic_jinlong_system_menu_process_state (value, name) values (5, '锁定菜单提交审核');
insert into dic_jinlong_system_menu_process_state (value, name) values (6, '锁定菜单审核通过');
insert into dic_jinlong_system_menu_process_state (value, name) values (7, '锁定菜单审核不通过');
insert into dic_jinlong_system_menu_process_state (value, name) values (8, '注销菜单提交审核');
insert into dic_jinlong_system_menu_process_state (value, name) values (9, '注销菜单审核通过');
insert into dic_jinlong_system_menu_process_state (value, name) values (10, '注销菜单审核不通过');

commit;