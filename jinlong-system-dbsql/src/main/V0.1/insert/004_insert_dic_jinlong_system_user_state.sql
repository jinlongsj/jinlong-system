-- 初始化表6 ：用户状态字典表数据
insert into dic_jinlong_system_user_state (value, name) values (1, '未激活');
insert into dic_jinlong_system_user_state (value, name) values (2, '已激活');
insert into dic_jinlong_system_user_state (value, name) values (3, '锁定用户');
insert into dic_jinlong_system_user_state (value, name) values (4, '注销用户');

commit;