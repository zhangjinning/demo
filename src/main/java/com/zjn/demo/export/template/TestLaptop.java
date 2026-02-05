package com.zjn.demo.export.template;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TestLaptop {

    private String productName;
    private String specifications;
    private String price;
    private String stockQuantity;
    private String salesVolume;
    private String manufactureDate;

    public static List<TestLaptop> generationTestData() {
        List<TestLaptop> data = new ArrayList<>();
        TestLaptop product1 = TestLaptop.builder()
                .productName("COLORFIRE MEOW 橘宝R16 七彩虹2025游戏笔记本电脑").specifications("锐龙7 H 255 16G 512G RTX5060").price("6999.00")
                .stockQuantity("999").salesVolume("40000+").manufactureDate("2025-06-18").build();
        TestLaptop product2 = TestLaptop.builder()
                .productName("华硕天选Air 2026 锐龙AI Max版14英寸AI游戏本笔记本电脑").specifications("锐龙AI Max+ 392 32G 1T 8060S核显 2.5K").price("10999.00")
                .stockQuantity("9999").salesVolume("200+").manufactureDate("2026-01-18").build();
        TestLaptop product3 = TestLaptop.builder()
                .productName("惠普HP【国家补贴】星Book Pro 16 2026 轻薄笔记本电脑").specifications("酷睿Ultra X7 358H 32G 1T 2.5K 240Hz AI").price("7999.00")
                .stockQuantity("100").salesVolume("60000+").manufactureDate("2026-01-21").build();
        data.add(product1);
        data.add(product2);
        data.add(product3);
        return data;
    }
}
