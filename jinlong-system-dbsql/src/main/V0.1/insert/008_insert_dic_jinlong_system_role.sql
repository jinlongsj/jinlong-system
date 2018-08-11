insert into tbl_jinlong_system_role (role_type, role_code, role_name, description, state, process_state)
values (1, 'ROLE_ADMIN', '超级管理员', '超级管理员主要负责初驾平台的用户管理、公共信息管理、广告信息管理、培训信息管理、驾校信息管理、用户发布信息管理、教练信息管理、学员信息管理等。');

insert into tbl_jinlong_system_role (role_name, description)
values (2, 'ROLE_MANAGER', '二级管理员', '超级管理员主要负责初驾平台的用户管理、公共信息管理、广告信息管理、培训信息管理、驾校信息管理、用户发布信息管理、教练信息管理、学员信息管理等。');

insert into tbl_jinlong_system_role (role_name, description)
values (3, 'ROLE_DRIVER_SCHOOL', '驾校用户', '驾校用户！主要为这些驾校用户提供驾校、车辆、场地、路线、教练、学员、信息推广、招生优惠等信息管理的一个驾校服务平台的用户觉。');

insert into tbl_jinlong_system_role (role_name, description)
values (4, 'ROLE_DRIVER_COACH', '驾驶教练用户', '面向教练用户的一个服务平台的用户角色');

insert into tbl_jinlong_system_role (role_name, description)
values (5, 'ROLE_DRIVER_SCHOOL', '驾驶学员用户', '面向学车学员用户的一个服务平台的用户角色');

commit;