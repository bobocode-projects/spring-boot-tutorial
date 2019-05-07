package com.bobocode.util;


import com.bobocode.model.Account;
import com.bobocode.model.Address;
import com.bobocode.model.Gender;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestDataGenerator {

    public Account generateAccount() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        Random random = new Random();

        Account account = new Account();
        account.setFirstName(person.getFirstName());
        account.setLastName(person.getLastName());
        account.setEmail(person.getEmail());
        account.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthOfYear(),
                person.getDateOfBirth().getDayOfMonth()));
        account.setGender(Gender.valueOf(person.getSex().name()));
        account.setBalance(BigDecimal.valueOf(random.nextInt(200_000)));
        account.setCreationTime(LocalDateTime.now());

        Address address = new Address();
        address.setCity(person.getAddress().getCity());
        address.setStreet(person.getAddress().getStreetNumber() + " " + person.getAddress().getStreet());
        address.setApartment(person.getAddress().getApartmentNumber());
        account.setAddress(address);

        return account;
    }

    public List<Account> generateAccountList(int size) {
        return Stream.generate(this::generateAccount)
                .limit(size)
                .collect(toList());
    }

}