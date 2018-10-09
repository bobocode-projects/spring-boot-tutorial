package com.bobocode;

import com.bobocode.util.TestDataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloBootMvc {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootMvc.class, args);
    }

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }
}
