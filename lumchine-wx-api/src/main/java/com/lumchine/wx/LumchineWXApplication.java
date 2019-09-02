package com.lumchine.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lumchine.db", "com.lumchine.core", "com.lumchine.wx"})
@MapperScan("com.lumchine.db.config.mybatis.mapping")
@EnableTransactionManagement
@EnableScheduling
public class LumchineWXApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumchineWXApplication.class, args);
    }

}