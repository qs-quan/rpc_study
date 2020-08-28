package service;

/**
 * ${DESCRIPTION}
 *   通过tomcat 插件启动web服务 暴露接口
 * @author 14684
 * @create 2020-24 22:37
 */
public class OrderServiceImp implements OrderService {
    @Override
    public String getOrder(String orderCode) {
        return orderCode + "调用hessian 服务";
    }
}
