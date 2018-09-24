-- 初始化表37 ：用户流程字典表数据
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (1, '新增用户组');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (2, '新增用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (3, '新增用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (4, '新增用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (5, '修改用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (6, '修改用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (7, '修改用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (8, '锁定用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (9, '锁定用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (10, '锁定用户组审核不通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (11, '删除用户组提交审核');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (12, '删除用户组审核通过');
INSERT INTO dic_jinlong_system_user_group_process_state (value, name) VALUES (13, '删除用户组审核不通过');

COMMIT;