package com.zjn.demo.ddd.domain.repository;

import com.zjn.demo.ddd.domain.model.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(Long accountId);
    void save(Account account);
}
