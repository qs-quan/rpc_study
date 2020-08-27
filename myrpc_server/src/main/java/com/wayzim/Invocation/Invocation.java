package com.wayzim.Invocation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-27 9:22
 */
@Data
@AllArgsConstructor
public class Invocation implements Serializable {

    /**
     * 接口名字
     */
    private String interfaceName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数列表
     */
    private Object[] params;

    /**
     * 参数类型列表
     */
    private Class<?>[] parameterTypes;


}
