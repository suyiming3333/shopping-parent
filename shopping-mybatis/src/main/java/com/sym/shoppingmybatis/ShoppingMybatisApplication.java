package com.sym.shoppingmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.sym.shoppingmybatis.mapper")
public class ShoppingMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMybatisApplication.class, args);
	}

}
