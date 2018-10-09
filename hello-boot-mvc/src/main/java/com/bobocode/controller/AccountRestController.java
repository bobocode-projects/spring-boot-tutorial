package com.bobocode.controller;

import com.bobocode.model.Account;
import com.bobocode.util.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    @Autowired
    TestDataGenerator dataGenerator;

    @GetMapping("/generate")
    public Account generate() {
        return dataGenerator.generateAccount();
    }
}
