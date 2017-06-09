package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

/**
 * Created by dell on 09-Jun-17.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<E,Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int initialCapacity = Math.max(16, (int)(collection.size() / 0.75)+1);
        map = new HashMap<E,Object>(initialCapacity);
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
