package com.jinlong.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.jinlong.system.dao",
		"com.jinlong.system.service", "com.jinlong.system.web"})
@MapperScan(basePackages={"com.jinlong.system.dao"})
public class JinlongSystemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinlongSystemWebApplication.class, args);
	}
}
