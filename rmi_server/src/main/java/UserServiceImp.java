import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * ${DESCRIPTION}
 * 扩展了UnicastRemoteObject类，并实现远程接口 HelloInterface
 * @author 14684
 * @create 2020-08-23 22:52
 */
public class UserServiceImp extends UnicastRemoteObject implements UserService {

    /**
     * 必须定义构造方法，即使是默认构造方法，也必须把它明确地写出来，
     * 因为它必须抛出出RemoteException异常
     * @throws RemoteException
     */
    protected UserServiceImp() throws RemoteException {
    }

    public String sayHello(String name) {
        return name + "成功调用了服务器";
    }
}
