package com.zjn.demo.ddd.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjn.demo.ddd.domain.model.Account;
import com.zjn.demo.ddd.domain.repository.AccountRepository;
import com.zjn.demo.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MbpAccountRepositoryAdapter implements AccountRepository {

    private final AccountMapper accountMapper;

    @Override
    public Optional<Account> findById(Long accountId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", accountId);
        return Optional.ofNullable(accountMapper.selectOne(queryWrapper));
    }

    @Override
    public void save(Account account) {
        accountMapper.insertOrUpdate(account);
    }
}
