package com.wzt.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableSwagger2
public class PractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiseApplication.class, args);
    }

}
