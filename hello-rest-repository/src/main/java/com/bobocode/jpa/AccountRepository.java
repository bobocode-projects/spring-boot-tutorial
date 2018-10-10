package com.bobocode.jpa;


import com.bobocode.model.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @RestResource(path = "/email")
    @Query("select a from Account a where a.email like concat('%', '@', :domain)")
    List<Account> findByEmailDomain(@Param("domain") String domain, Pageable pageable);
}
