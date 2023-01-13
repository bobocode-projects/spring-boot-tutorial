package com.bobocode.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "email")
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "creation_time")
    private LocalDateTime creationTime = LocalDateTime.now();

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public void setAddress(Address address) {
        if (address == null) {
            if (this.address != null) {
                this.address.setAccount(null);
            }
        } else {
            address.setAccount(this);
        }
        this.address = address;
    }
}
