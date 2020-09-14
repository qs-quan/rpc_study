package com.wayzim.service;


import com.wayzim.wms.datahub.ErpOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-09-11 20:04
 */
@Service
public class HelloService {

    @Autowired
    private ErpOrderService erpOrderService;

    public String helloOrder(String orderId) {
        String orderName = erpOrderService.getOrderName(orderId);
        return orderName;
    }
}
