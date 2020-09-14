package com.wayzim.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-09-12 15:12
 */
public class CustomerMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
        context.start();
        HelloService helloService = (HelloService) context.getBean("helloService");
        String s = helloService.helloOrder("123");
        System.out.println( s ); // 显示调用结果
        System.in.read(); // 按任意键退出

    }
}
