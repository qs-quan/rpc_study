package com.wayzim.provider;

import com.wayzim.pojo.URL;
import com.wayzim.register.NativeRegister;
import com.wayzim.service.IHelloService;
import com.wayzim.service.IHelloServiceImpl;
import com.wayzim.tomcat.HttpServer;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-27 8:49
 */
public class ServiceProvider {

    /**
     * 真正的注册服务
     *
     * @param args
     */
    public static void main(String[] args) {
        String interfaceName = IHelloService.class.getName();
        URL url = new URL("localhost", 8888);
        Class impClass = IHelloServiceImpl.class;
        NativeRegister.register(interfaceName, url, impClass);

        /**
         * 启动tomcat 暴露服务
         */
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }
}
