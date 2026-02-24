package com.zjn.demo.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;

public class MyBatisPlusGeneratorUtil {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("zhangjinning")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.zjn.demo")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .addInclude("t_user")
                        .addTablePrefix("t_")
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
