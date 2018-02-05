package com.coderpwh.effective_java.chapter1.one;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author coderpwh
 * @Date: 2018/1/30.
 * @Description:
 */
public class Services {

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";


    public static void registerDefaultProvider(Provider p) {
        registerProvicer(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvicer(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name:" + name);
        }
        return p.newService();
    }



}
