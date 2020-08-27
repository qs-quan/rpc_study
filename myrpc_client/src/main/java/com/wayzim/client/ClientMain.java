package com.wayzim.client;

import com.wayzim.Invocation.Invocation;
import com.wayzim.service.IHelloService;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-27 10:49
 */
public class ClientMain {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8888;
        Invocation invocation = new Invocation(
                IHelloService.class.getName(),
                "helloWorld",
                new Object[]{"myRPC客户端"},
                new Class[]{String.class});
        HttpClient httpClient = new HttpClient();
        String result = httpClient.post(hostname, port, invocation);
        System.out.println(result);

    }


}
