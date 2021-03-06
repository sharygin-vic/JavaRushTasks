package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public Object clone() {
        AmigoSet<E> res = null;
        try {
            res = (AmigoSet<E>) super.clone();
            res.map = (HashMap<E, Object>) map.clone();
        }
        catch (Exception e) {
            throw new InternalError();
        }
        return res;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map,"capacity"));
        out.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactory = in.readFloat();
        map = new HashMap<E,Object>(capacity, loadFactory);
    }

}
