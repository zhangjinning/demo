package com.zjn.demo.ddd.application;

import com.zjn.demo.ddd.domain.repository.AccountRepository;
import com.zjn.demo.ddd.domain.service.NotificationService;
import com.zjn.demo.ddd.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        // 1. 获取账户（依赖仓储接口）
        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("源账户不存在"));
        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("目标账户不存在"));

        // 2. 执行核心业务逻辑（调用领域对象的方法）
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        // 3. 保存状态
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // 4. 触发副作用（发送通知）
        notificationService.sendTransferSuccess(fromId, amount);
    }
}
