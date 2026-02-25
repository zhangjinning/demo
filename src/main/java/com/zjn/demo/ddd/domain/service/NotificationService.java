package com.zjn.demo.ddd.domain.service;

import java.math.BigDecimal;

public interface NotificationService {

    void sendTransferSuccess(Long accountId, BigDecimal amount);
}
