import java.rmi.Naming;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-23 23:13
 */
public class rmi_client {

    public static void main(String[] args) {
        try {
//            UserService hello = (UserService) Naming.lookup("Hello");

            // 如果要从另一台启动了RMI注册服务的机器上查找hello实例
            UserService hello = (UserService)Naming.lookup("rmi://localhost:12345/Hello");

            // 调用远程方法
            System.out.println(hello.sayHello("傻瓜：  "));
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }
    }
}
