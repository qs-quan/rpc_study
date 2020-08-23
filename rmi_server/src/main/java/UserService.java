import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ${DESCRIPTION}
 * 远程接口必须扩展接口java.rmi.Remote
 * @author 14684
 * @create 2020-08-23 22:51
 */
public interface UserService extends Remote {

    /**
     * 远程接口方法必须抛出 java.rmi.RemoteException
     */
    String sayHello(String name) throws RemoteException;
}
