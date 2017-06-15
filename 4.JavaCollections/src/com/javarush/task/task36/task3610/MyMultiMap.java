package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int res = 0;
        for (Map.Entry<K, List<V>> item : map.entrySet()) {
            res += item.getValue().size();
        }
        return res;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V res = null;
        List<V> list;
        if (!containsKey(key)) {
            list = new ArrayList<V>(repeatCount);
            map.put(key, list);
        }
        else {
            list = map.get(key);
        }
        if (list.size() > 0) {
            res = list.get(list.size()-1);
        }
        if (list.size() == repeatCount) {
            list.remove(0);
        }
        list.add(value);
        return res;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (!map.containsKey(key)) {
            return null;
        }
        List<V> list = map.get(key);
        V res = null;
        if (list.size() > 0) {
            res = list.remove(0);
        }
        if (list.size() == 0) {
            map.remove(key);
        }
        return res;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> res = new ArrayList<V>(size());
        for (Map.Entry<K, List<V>> item : map.entrySet()) {
            List<V> list = item.getValue();
            for (V value : list) {
                res.add(value);
            }
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (Map.Entry<K, List<V>> item : map.entrySet()) {
            List<V> list = item.getValue();
            for (V curValue : list) {
                if (value.equals(curValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}