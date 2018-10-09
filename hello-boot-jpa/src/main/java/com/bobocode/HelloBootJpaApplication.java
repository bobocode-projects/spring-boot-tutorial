package com.bobocode;

import com.bobocode.jpa.AccountRepository;
import com.bobocode.util.TestDataGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HelloBootJpaApplication implements InitializingBean {
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloBootJpaApplication.class, args);
    }

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }


    @Override
    public void afterPropertiesSet() {
        accountRepository.saveAll(dataGenerator().generateAccountList(10));
    }
}
