package com.zjn.demo.ddd.infrastructure.notification;

import com.zjn.demo.ddd.domain.service.NotificationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SmsNotificationAdapter implements NotificationService {
    @Override
    public void sendTransferSuccess(Long accountId, BigDecimal amount) {
        // 调用具体的第三方短信 API
        System.out.println("Sending SMS to account " + accountId + ": Transfer of " + amount + " successful.");
        // smsClient.send(...);
    }
}
