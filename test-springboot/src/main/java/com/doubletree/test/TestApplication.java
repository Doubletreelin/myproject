package com.doubletree.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication
@MapperScan("com.doubletree.test.mapper")
public class TestApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TestApplication.class, args);
	}
}