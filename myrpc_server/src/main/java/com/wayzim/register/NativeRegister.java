package com.wayzim.register;

import com.wayzim.pojo.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-26 20:49
 */
public class NativeRegister {

    public static Map<String, Map<URL, Class>> registerCenter = new HashMap<String, Map<URL, Class>>();

    /**
     * 注册服务接口
     * @param interfaceName   接口名
     * @param url             服务地址
     * @param implClazz       接口实现类
     */
    public static void register(String interfaceName, URL url, Class implClazz) {
        Map<URL, Class> map = registerCenter.get(interfaceName);
        if (map == null) {
            map = new HashMap<URL, Class>();
        }
        map.put(url, implClazz);
        registerCenter.put(interfaceName, map);
    }

    /**
     * 获取服务方法
     * @param interfaceName
     * @param url
     * @return
     */
    public static Class get(String interfaceName, URL url) {
        Map<URL, Class> map = registerCenter.get(interfaceName);
        return map == null ? null : map.get(url);
    }
}
