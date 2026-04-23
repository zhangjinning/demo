package com.zjn.demo.ddd.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangjinning
 * @since 2026-02-25
 */
@Getter
@TableName("t_account")
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private final Long id;

    private BigDecimal balance;

    public Account(Long accountId, BigDecimal balance) {
        this.id = accountId;
        this.balance = balance;
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("金额必须大于0");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalStateException("余额不足");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("金额必须大于0");
        }
        this.balance = this.balance.add(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
            "id = " + id +
            ", balance = " + balance +
            "}";
    }
}
