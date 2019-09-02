package com.lumchine.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lumchine.db", "com.lumchine.core"})
@MapperScan("com.lumchine.db.config.mybatis.mapping")
public class LumchineCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumchineCoreApplication.class, args);
    }

}