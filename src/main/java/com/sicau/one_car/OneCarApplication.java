package com.sicau.one_car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.sicau.one_car.dao")
@EnableTransactionManagement
@ServletComponentScan
public class OneCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneCarApplication.class, args);
    }

}
