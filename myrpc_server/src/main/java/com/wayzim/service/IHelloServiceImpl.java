package com.wayzim.service;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-26 20:44
 */
public class IHelloServiceImpl implements IHelloService {
    public String helloWorld(String name) {
        return name + "调用的myrpc server";
    }
}
