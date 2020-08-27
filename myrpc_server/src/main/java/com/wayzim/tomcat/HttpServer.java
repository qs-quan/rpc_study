package com.wayzim.tomcat;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-27 9:09
 */
public class HttpServer {

    public void start(String hostName, Integer port) {
        // 实例化tomcat
        Tomcat tomcat = new Tomcat();

        // 构建Server
        Server server = tomcat.getServer();

        // 构建Service
        Service servcie = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);
        connector.setURIEncoding("UTF-8");

        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostName);

        Host host = new StandardHost();
        host.setName(hostName);

        String contextPath = "/myRpc";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());//生命周期监听

        // 按照server.xml 添加节点
        host.addChild(context);
        engine.addChild(host);
        servcie.setContainer(engine);
        servcie.addConnector(connector);
        // 注册servlet
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
        // servlet mapping
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
            tomcat.getServer().await();
        }  catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
