package com.zjn.demo.ddd.interfaces.web;

import com.zjn.demo.ddd.application.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/doTransfer")
    public void doTransfer(@RequestParam Long from,
                           @RequestParam Long to,
                           @RequestParam BigDecimal amount) {
        // 仅负责参数解析和调用应用服务，不包含业务逻辑
        transferService.transfer(from, to, amount);
    }
}
