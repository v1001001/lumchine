package com.lumchine.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lumchine.db", "com.lumchine.core", "com.lumchine.admin"})
@MapperScan("com.lumchine.db.config.mybatis.mapping")
@EnableTransactionManagement
@EnableScheduling
public class LumchineAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumchineAdminApplication.class, args);
    }

}