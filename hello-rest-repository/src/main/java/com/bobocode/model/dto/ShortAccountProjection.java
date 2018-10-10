package com.bobocode.model.dto;

import com.bobocode.model.Account;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "short", types = Account.class)
public interface ShortAccountProjection {
    Long getId();

    String getEmail();

    String getFirstName();

    String getLastName();
}
