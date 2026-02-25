package com.zjn.demo.service.impl;

import com.zjn.demo.ddd.domain.model.Account;
import com.zjn.demo.mapper.AccountMapper;
import com.zjn.demo.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangjinning
 * @since 2026-02-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
