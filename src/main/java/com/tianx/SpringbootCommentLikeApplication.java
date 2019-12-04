package com.tianx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tianx.mapper")
public class SpringbootCommentLikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCommentLikeApplication.class, args);
    }

}
