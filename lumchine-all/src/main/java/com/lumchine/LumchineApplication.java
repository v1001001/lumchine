package com.lumchine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lumchine"})
@MapperScan("com.lumchine.db.config.mybatis.mapping")
@EnableTransactionManagement
@EnableScheduling
public class LumchineApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LumchineApplication.class, args);
    }

}