package com.sym.shopping.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sym.shoppingmybatis.mapper")
public class ShoppingMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMemberApplication.class, args);
    }

}
