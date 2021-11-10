package com.cyquen.miniprogramserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.cyquen.miniprogramserver.filter")
public class MiniprogramServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprogramServerApplication.class, args);
    }

}
