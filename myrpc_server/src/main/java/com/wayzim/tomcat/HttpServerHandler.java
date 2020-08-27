package com.wayzim.tomcat;

import com.wayzim.Invocation.Invocation;
import com.wayzim.pojo.URL;
import com.wayzim.register.NativeRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 * 处理远程请求调用
 *
 * @author 14684
 * @create 2020-08-27 9:15
 */
public class HttpServerHandler {


    public void handle(HttpServletRequest req, HttpServletResponse resp) {


        try {
            /**
             * 1：通过请求流获取请求服务参数
             */
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();

            /**
             * 2:从注册中心获取服务
             */
            URL url = new URL("localhost", 8888);
            Class implClsaa = NativeRegister.get(invocation.getInterfaceName(), url);

            /**
             * 反射调用
             */
            Method method = implClsaa.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            String result = (String) method.invoke(implClsaa.newInstance(), invocation.getParams());

            /**
             * 结果返回
             */
            IOUtils.write(result, resp.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }


    }
}
