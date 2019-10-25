package com.sicau.one_car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class OneCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneCarApplication.class, args);
    }

}
