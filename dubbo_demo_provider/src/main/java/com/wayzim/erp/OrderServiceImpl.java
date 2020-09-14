package com.wayzim.erp;

import com.wayzim.wms.datahub.ErpOrderService;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-09-11 15:16
 */
public class OrderServiceImpl implements ErpOrderService {
    public String getOrderName(String orderId) {
        return "hello" + orderId;
    }
}
