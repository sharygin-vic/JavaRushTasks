package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //WeakHashMap - vic's solution

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //add your code here
        if (!cache.containsKey(key)) {
            V res = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, res);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        // add your code here
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    public int size() {
        return cache.size();
    }
}
