package com.github0604hx;

/*
 * @project nerve-boot
 * @file    org.nerve.demo.DemoRestApp
 * CREATE   2022年10月27日 10:49 上午
 * --------------------------------------------------------------
 * 0604hx   https://github.com/0604hx
 * --------------------------------------------------------------
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.nerve", "com.github0604hx"})
@MapperScan({"org.nerve.boot.module"})
public class ExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }
}
