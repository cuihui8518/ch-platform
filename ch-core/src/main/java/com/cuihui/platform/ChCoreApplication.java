package com.cuihui.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cuihui.platform.impl.dao")
public class ChCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChCoreApplication.class, args);
    }
}
