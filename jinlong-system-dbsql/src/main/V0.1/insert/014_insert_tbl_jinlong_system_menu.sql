-- 初始化表22：菜单信息表
-- 一级菜单（系统级）
-- 1
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('系统管理系统', 1, 0, 0, '#', 0, '系统管理，主要分为用户管理、角色管理、菜单管理三个子模块', 1);
-- 2
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('业务管理系统', 1, 0, 0, '#', 0, '用户管理，主要管理用户的信息，分为用户新增、用户信息管理两个个子页面', 1);
-- 3
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校用户系统', 1, 0, 0, '#', 0, null, 1);
-- 4
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('教练用户系统', 1, 0, 0, '#', 0, null, 1);
-- 5
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学员用户系统', 1, 0, 0, '#', 0, null, 1);
-- 6
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('车管所用户系统', 1, 0, 0, '#', 0, null, 1);
-- 7
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('培驾用户系统', 1, 0, 0, '#', 0, null, 1);
-- 8
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('其它用户系统', 1, 0, 0, '#', 0, null, 1);



-- 二级菜单：
-- 管理员系统管理后台：
-- 9
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户管理', 1, 1, 1, '#', 0, null, 1);
-- 10
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('权限管理', 1, 1, 1, '#', 0, null, 1);
-- 11
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('数据分析', 1, 1, 1, '#', 0, null, 1);
-- 12
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('日志管理', 1, 1, 1, '#', 0, null, 1);

-- 业务管理系统后台：
-- 13
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('公共信息', 1, 1, 2, '#', 0, '用户管理，主要管理用户的信息，分为用户新增、用户信息管理两个个子页面', 1);
-- 14
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校管理', 1, 1, 2, '#', 0, null, 1);
-- 15
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户新闻', 1, 1, 2, '#', 0, null, 1);
-- 16
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('教练管理', 1, 1, 2, '#', 0, null, 1);
-- 17
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学员管理', 1, 1, 2, '#', 0, null, 1);
-- 18
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('交易信息', 1, 1, 2, '#', 0, null, 1);
-- 19
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('市场行情', 1, 1, 2, '#', 0, null, 1);

-- 驾校用户后台：
-- 20
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校管理', 1, 1, 3, '#', 0, null, 1);
-- 21
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('报名推广', 1, 1, 3, '#', 0, null, 1);
-- 22
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学员管理', 1, 1, 3, '#', 0, null, 1);
-- 23
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('教练管理', 1, 1, 3, '#', 0, null, 1);
-- 24
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('约车管理', 1, 1, 3, '#', 0, null, 1);
-- 25
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('消息管理', 1, 1, 3, '#', 0, null, 1);

-- 教练用户后台：
-- 26
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('课程', 1, 1, 4, '#', 0, null, 1);
-- 27
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学员', 1, 1, 4, '#', 0, null, 1);
-- 28
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('个人', 1, 1, 4, '#', 0, null, 1);

-- 学员用户后台：
-- 29
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('约课', 1, 1, 5, '#', 0, null, 1);
-- 30
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('找教练', 1, 1, 5, '#', 0, null, 1);
-- 31
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学车', 1, 1, 5, '#', 0, null, 1);



-- 三级菜单

-- 管理员系统管理后台：
-- 32
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户信息管理', 1, 2, 9, 'jsp/user/user_manage.jsp', 0, null, 1);
-- 33
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户组管理', 1, 2, 9, '#', 0, null, 1);
-- 34
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('角色信息管理', 1, 2, 9, 'jsp/role/role_manage.jsp', 0, null, 1);
-- 35
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('角色组管理', 1, 2, 9, '#', 0, null, 1);
-- 36
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('权限功能管理', 1, 2, 10, '#', 0, null, 1);
-- 37
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('菜单信息管理', 1, 2, 10, 'jsp/menu/menu_manage.jsp', 0, null, 1);
-- 38
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('操作功能管理', 1, 2, 10, '#', 0, null, 1);
-- 39
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('页面功能管理', 1, 2, 10, '#', 0, null, 1);
-- 40
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('资源信息管理', 1, 2, 10, '#', 0, null, 1);
-- 41
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户IP管理', 1, 2, 11, '#', 0, null, 1);
-- 42
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户日志统计', 1, 2, 11, '#', 0, null, 1);
-- 43
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户统计数据', 1, 2, 11, '#', 0, null, 1);
-- 44
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户数据分析', 1, 2, 11, '#', 0, null, 1);
-- 45
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户数据刻画', 1, 2, 11, '#', 0, null, 1);
-- 46
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户日志管理', 1, 2, 12, '#', 0, null, 1);
-- 47
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('角色日志管理', 1, 2, 12, '#', 0, null, 1);
-- 48
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('权限日志管理', 1, 2, 12, '#', 0, null, 1);
-- 49
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('菜单日志管理', 1, 2, 12, '#', 0, null, 1);
-- 50
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('操作日志管理', 1, 2, 12, '#', 0, null, 1);

-- 业务管理系统后台：
-- 51
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业新闻类别管理', 1, 2, 13, '#', 0, null, 1);
-- 52
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业新闻管理', 1, 2, 13, '#', 0, null, 1);
-- 53
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('服务业新闻类别管理', 1, 2, 13, '#', 0, null, 1);
-- 54
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('服务业新闻管理', 1, 2, 13, '#', 0, null, 1);
-- 55
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('广告信息类别管理', 1, 2, 13, '#', 0, null, 1);
-- 56
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('广告信息管理', 1, 2, 13, '#', 0, null, 1);
-- 57
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构类别管理', 1, 2, 14, '#', 0, null, 1);
-- 58
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业类别管理', 1, 2, 14, '#', 0, null, 1);
-- 59
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('地区信息管理', 1, 2, 14, '#', 0, null, 1);
-- 60
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构管理', 1, 2, 14, '#', 0, null, 1);
-- 61
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构留言管理', 1, 2, 14, '#', 0, null, 1);
-- 62
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户留言管理', 1, 2, 14, '#', 0, null, 1);
-- 63
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构地址管理', 1, 2, 14, '#', 0, null, 1);
-- 64
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构新闻类别管理', 1, 2, 15, '#', 0, null, 1);
-- 65
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构新闻管理', 1, 2, 15, '#', 0, null, 1);
-- 66
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户博客类别管理', 1, 2, 15, '#', 0, null, 1);
-- 67
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户博客管理', 1, 2, 15, '#', 0, null, 1);
-- 68
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('供求类别管理', 1, 2, 16, '#', 0, null, 1);
-- 69
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('供应产品管理', 1, 2, 16, '#', 0, null, 1);
-- 70
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('求购产品管理', 1, 2, 16, '#', 0, null, 1);
-- 71
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('市场商情管理', 1, 2, 16, '#', 0, null, 1);

-- 驾校用户后台：
-- 72
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校信息', 1, 2, 20, 'jsp/school/school_detail.jsp', 0, null, 1);
-- 73
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校评价', 1, 2, 20, 'jsp/school_comment/school_comment_manage.jsp', 0, null, 1);
-- 74
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('车辆管理', 1, 2, 20, 'jsp/vehicle/vehicle_manage.jsp', 0, null, 1);
-- 75
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('场地管理', 1, 2, 20, 'jsp/field/field_manage.jsp', 0, null, 1);
-- 76
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('班车路线', 1, 2, 20, 'jsp/route/route_manage.jsp', 0, null, 1);
-- 77
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('报名课程', 1, 2, 21, 'jsp/curriculum/curriculum_manage.jsp', 0, null, 1);
-- 78
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('广告投放', 1, 2, 21, 'jsp/school_advert/school_advert_manage.jsp', 0, null, 1);
-- 79
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('报名优惠', 1, 2, 21, 'jsp/sign_discount/sign_discount_manage.jsp', 0, null, 1);
-- 80
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('报名学员', 1, 2, 21, 'jsp/sign/sign_manage.jsp', 0, null, 1);
-- 81
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('学员信息', 1, 2, 22, 'jsp/student/student_manage.jsp', 0, null, 1);
-- 82
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('考试管理', 1, 2, 22, 'jsp/examinaction/examinaction_manage.jsp', 0, null, 1);
-- 83
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('待激活学员', 1, 2, 22, 'jsp/student/student_certification.jsp', 0, null, 1);
-- 84
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增学员', 1, 2, 22, 'jsp/student/student_add.jsp', 0, null, 1);
-- 85
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('教练信息', 1, 2, 23, 'jsp/coach/coach_manage.jsp', 0, null, 1);
-- 86
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('教练评价', 1, 2, 23, 'jsp/coach_comment/coach_comment_manage.jsp', 0, null, 1);
-- 87
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增教练', 1, 2, 23, 'jsp/coach/coach_add.jsp', 0, null, 1);
-- 88
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('待激活教练', 1, 2, 23, 'jsp/coach/coach_certification.jsp', 0, null, 1);
-- 89
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('约车日程', 1, 2, 24, 'jsp/about_car/about_car_manage.jsp', 0, null, 1);
-- 90
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('练车评价', 1, 2, 24, 'jsp/about_car/about_car_comment.jsp', 0, null, 1);
-- 91
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('发送消息', 1, 2, 25, 'jsp/message/sent_message.jsp', 0, null, 1);
-- 92
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('已发消息', 1, 2, 25, 'jsp/message/message_manage.jsp', 0, null, 1);



-- 四级菜单：
-- 业务管理系统后台：
-- 93
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增行业新闻类别', 1, 3, 51, '# ', 0, null, 1);
-- 94
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业新闻类别管理', 1, 3, 51, '#', 0, null, 1);
-- 95
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理行业新闻', 1, 3, 51, '#', 0, null, 1);
-- 96
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增行业新闻', 1, 3, 52, '#', 0, null, 1);
-- 97
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业新闻管理', 1, 3, 52, '#', 0, null, 1);
-- 98
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理行业新闻', 1, 3, 52, '#', null, null, 1);
-- 99
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增服务业新闻类别', 1, 3, 53, '#', null, null, 1);
-- 100
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('服务业新闻类别管理', 1, 3, 53, '#', null, null, 1);
-- 101
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理服务业新闻', 1, 3, 53, '#', null, null, 1);
-- 102
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增服务业新闻', 1, 3, 54, '#', null, null, 1);
-- 103
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('服务业新闻管理', 1, 3, 54, '#', null, null, 1);
-- 104
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理服务业新闻', 1, 3, 54, '#', null, null, 1);
-- 105
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增广告信息类别', 1, 3, 55, '#', null, null, 1);
-- 106
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('广告信息类别管理', 1, 3, 55, '#', null, null, 1);
-- 107
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理广告信息', 1, 3, 55, '#', null, null, 1);
-- 108
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增广告信息', 1, 3, 56, '#', 0, null, 1);
-- 109
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('广告信息管理', 1, 3, 56, '#', 0, null, 1);
-- 110
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理广告信息', 1, 3, 56, '#', 0, null, 1);
-- 111
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增驾校机构类别', 1, 3, 57, '#', 0, null, 1);
-- 112
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构类别信息管理', 1, 3, 57, '#', 0, null, 1);
-- 113
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增一级行业类别', 1, 3, 58, '#', 0, null, 1);
-- 114
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('行业类别信息管理', 1, 3, 58, '#', 0, null, 1);
-- 115
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增一级地区', 1, 3, 59, '#', 0, null, 1);
-- 116
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('地区信息管理', 1, 3, 59, '#', 0, null, 1);
-- 117
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构信息管理', 1, 3, 60, '#', 0, null, 1);
-- 118
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过驾校类别管理驾校', 1, 3, 60, '#', 0, null, 1);
-- 119
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过行业管理驾校', 1, 3, 60, '#', 0, null, 1);
-- 120
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过地区管理驾校', 1, 3, 60, '#', 0, null, 1);
-- 121
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校留言信息管理', 1, 3, 61, '#', 0, null, 1);
-- 122
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('管理驾校机构下的留言', 1, 3, 61, '#', 0, null, 1);
-- 123
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户留言信息管理', 1, 3, 62, '#', 0, null, 1);
-- 124
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('管理用户下的留言', 1, 3, 62, '#', 0, null, 1);
-- 125
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构地址管理', 1, 3, 63, '#', 0, null, 1);
-- 126
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过驾校机构管理地址', 1, 3, 63, '#', 0, null, 1);
-- 127
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增驾校机构新闻类别', 1, 3, 64, '#', 0, null, 1);
-- 128
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构新闻类别管理', 1, 3, 64, '#', 0, null, 1); 
-- 129
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理驾校新闻', 1, 3, 64, '#', 0, null, 1); 
-- 130
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('驾校机构新闻管理', 1, 3, 65, '#', 0, null, 1);
-- 131
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理驾校新闻', 1, 3, 65, '#', 0, null, 1); 
-- 132
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增用户博客类别', 1, 3, 66, '#', 0, null, 1);
-- 133
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户博客类别类表', 1, 3, 66, '#', 0, null, 1);
-- 134
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理用户博客', 1, 3, 66, '#', 0, null, 1); 
-- 135
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('用户博客类别管理', 1, 3, 67, '#', 0, null, 1);
-- 136
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理用户博客', 1, 3, 67, '#', 0, null, 1); 
-- 137
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('新增供求类别', 1, 3, 68, '#', 0, null, 1);
-- 138
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('供求类别管理', 1, 3, 68, '#', 0, null, 1);
-- 139
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('供应产品信息管理', 1, 3, 69, '#', 0, null, 1);
-- 140
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理供应产品', 1, 3, 69, '#', 0, null, 1);
-- 141
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过组织管理供应产品', 1, 3, 69, '#', 0, null, 1);
-- 142
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过行业管理供应产品', 1, 3, 69, '#', 0, null, 1);
-- 143
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('求购产品信息管理', 1, 3, 70, '#', 0, null, 1);
-- 144
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过类别管理求购产品', 1, 3, 70, '#', 0, null, 1);
-- 145
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过组织管理求购产品', 1, 3, 70, '#', 0, null, 1);
-- 146
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过行业管理求购产品', 1, 3, 70, '#', 0, null, 1);
-- 147
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('发布市场行情信息', 1, 3, 71, '#', 0, null, 1);
-- 148
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('市场行情信息管理', 1, 3, 71, '#', 0, null, 1);
-- 149
insert into tbl_jinlong_system_menu (menu_name, type_id, level_id, parent_id, menu_url, image, description, state)
values ('通过行业管理市场行情', 1, 3, 71, '#', 0, null, 1);

commit;
