package com.dageda.vueshiromodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dageda.vueshiromodel.dao")
public class VueshiromodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueshiromodelApplication.class, args);
    }

}
