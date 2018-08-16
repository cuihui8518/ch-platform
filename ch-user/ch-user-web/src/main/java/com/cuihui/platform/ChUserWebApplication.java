package com.cuihui.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cuihui.platform.dao")
public class ChUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChUserWebApplication.class, args);
    }
}
