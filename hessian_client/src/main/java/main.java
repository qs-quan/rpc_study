import com.caucho.hessian.client.HessianProxyFactory;
import service.OrderService;

import java.net.MalformedURLException;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-24 22:50
 */
public class main {

    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:9090/hessianServer/hessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        OrderService orderService = (OrderService) factory.create(OrderService.class, url);
        String hello = orderService.getOrder("mi");
        System.out.println(hello);
    }
}
