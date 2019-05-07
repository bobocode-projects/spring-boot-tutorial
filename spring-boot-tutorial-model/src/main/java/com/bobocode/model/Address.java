package com.bobocode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue
	private Long id;

	private String city;

	private String street;

	private String apartment;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;
}
