import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-23 22:54
 */
public class main {

    public static void main(String[] args) {
        try {
            // 启动RMI注册服务，指定端口为1099　（1099为默认端口）
            // 也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
            // 这里用这种方式避免了再打开一个DOS窗口
            // 而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个stub类为它所用
            LocateRegistry.createRegistry(12345);
            // 创建远程对象的一个或多个实例
            // 可以用不同名字注册不同的实例
            UserService service = new UserServiceImp();
            // 如果要把hello实例注册到另一台启动了RMI注册服务的机器上
             Naming.rebind("rmi://localhost:12345/Hello",service);
//            Naming.rebind("Hello", (Remote) service);
            System.out.println("Hello Server is ready.");
        } catch (RemoteException e) {
            System.out.println("Hello Server failed: " + e);
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
