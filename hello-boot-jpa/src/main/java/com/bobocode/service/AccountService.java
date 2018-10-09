package com.bobocode.service;

import com.bobocode.jpa.AccountRepository;
import com.bobocode.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account deposit(Long accountId, BigDecimal value) {
        Account account = accountRepository.findById(accountId).get();
        account.setBalance(account.getBalance().add(value));
        return account;
    }
}
