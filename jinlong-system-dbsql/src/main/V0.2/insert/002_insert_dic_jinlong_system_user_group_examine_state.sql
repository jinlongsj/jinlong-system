-- 初始化表34 ：用户审核状态字典表数据
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (1, '未审核');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (2, '审核通过');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (3, '审核未通过');
INSERT INTO dic_jinlong_system_user_group_examine_state (value, name) VALUES (4, '已失效');

COMMIT;