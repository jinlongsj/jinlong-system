/**
 * FileName: 	 MyBatisConfig.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月27日 下午6:24:12 
 **/
package com.jinlong.system.dao.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * MyBatis数据库配置类，解决mybatis-1.3.jar没有解决dataSource初始化的问题
 * @author:	肖学进
 * @date: 2018年6月27日 下午6:24:12
 */
@Configuration
public class MyBatisConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;


    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println("**************************************************");
        System.out.println("url = " + dataSourceProperties.getUrl());
        System.out.println("driverClassName = " + dataSourceProperties.getDriverClassName());
        System.out.println("userName = " + dataSourceProperties.getUsername());
        System.out.println("password = " + dataSourceProperties.getPassword());
        System.out.println("**************************************************");
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;

    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

}
