-- 初始化表31 ：用户状态字典表数据
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (1, '未激活');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (2, '已激活');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (3, '锁定用户');
INSERT INTO dic_jinlong_system_user_group_state (value, name) VALUES (4, '注销用户');

COMMIT;