package com.bobocode.config;

import com.bobocode.jpa.AccountRepository;
import com.bobocode.util.TestDataGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataGeneratorConfig implements InitializingBean {

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }


    @Override
    public void afterPropertiesSet() {
        accountRepository.saveAll(dataGenerator().generateAccountList(10));
    }
}
