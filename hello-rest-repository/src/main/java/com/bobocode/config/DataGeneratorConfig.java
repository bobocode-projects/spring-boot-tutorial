package com.bobocode.config;

import com.bobocode.jpa.AccountRepository;
import com.bobocode.util.TestDataGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class DataGeneratorConfig {

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void afterPropertiesSet() {
        accountRepository.saveAll(dataGenerator().generateAccountList(100));
    }
}
