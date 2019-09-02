package com.lumchine.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lumchine.db"})
@MapperScan("com.lumchine.db.dao" )
public class LumchinDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumchinDbApplication.class, args);
    }

}