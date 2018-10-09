package com.bobocode.controller;

import com.bobocode.jpa.AccountRepository;
import com.bobocode.model.Account;
import com.bobocode.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id) {
        return accountRepository.findById(id).get();
    }

    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }

    @PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam BigDecimal value) {
        return accountService.deposit(id, value);
    }

    @PostMapping("/generate")
    public void generateAccounts(@RequestParam int count) {

    }
}
