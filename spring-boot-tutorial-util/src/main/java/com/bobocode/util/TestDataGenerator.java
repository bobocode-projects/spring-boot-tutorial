package com.bobocode.util;


import bobocode.model.Account;
import bobocode.model.Gender;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestDataGenerator {

    public Account generateAccount() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        Random random = new Random();


        Account fakeAccount = new Account();
        fakeAccount.setFirstName(person.getFirstName());
        fakeAccount.setLastName(person.getLastName());
        fakeAccount.setEmail(person.getEmail());
        fakeAccount.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthOfYear(),
                person.getDateOfBirth().getDayOfMonth()));
        fakeAccount.setGender(Gender.valueOf(person.getSex().name()));
        fakeAccount.setBalance(BigDecimal.valueOf(random.nextInt(200_000)));
        fakeAccount.setCreationTime(LocalDateTime.now());

        return fakeAccount;
    }

    public List<Account> generateAccountList(int size) {
        return Stream.generate(this::generateAccount)
                .limit(size)
                .collect(toList());
    }

}