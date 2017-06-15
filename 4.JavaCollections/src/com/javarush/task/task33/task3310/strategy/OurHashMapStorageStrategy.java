package com.javarush.task.task33.task3310.strategy;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by dell on 15-Jun-17.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (Entry entry : table) {
            Entry current = entry;
            while (true) {
                if (current == null) break;
                if (value.equals(current.getValue())) return true;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        addEntry(hash, key, value, indexFor(hash, table.length));
    }

    @Override
    public Long getKey(String value) {
        if (value == null) return 0L;
        for (Entry e : table) {
            Entry current = e;
            while (true) {
                if (current == null) break;
                if (value.equals(current.getValue())) {
                    return current.getKey();
                }
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) return entry.getValue();
        return null;
    }

    int hash(Long k) {
        if (k == null) return  0;
        int hCode = k.hashCode();
        return hCode ^ (hCode >>> 16);
    }

    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    Entry getEntry(Long key) {
        int hash = hash(key);
        Entry entry = table[indexFor(hash, table.length)];
        while (true) {
            if (entry == null) return null;
            if (entry.getKey().equals(key)) return entry;
        }
    }

    void resize(int newCapacity) {
        if (table.length == newCapacity) return;
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        threshold = (int) (newCapacity * this.loadFactor);
        table = newTable;
    }

    void transfer(Entry[] newTable) {
        for (Entry entry : table) {
            if (entry != null) {
                Entry current = entry;
                while (true) {
                    if (current == null) break;
                    Entry next = current.next;
                    int newIndex = indexFor(current.hash, newTable.length);
                    Entry lastFromNewTable = newTable[newIndex];
                    newTable[newIndex] = current;
                    current.next = lastFromNewTable;
                    current = next;
                }
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (size >= threshold && table[bucketIndex] != null) {
            int newInitialCapacity = table.length * 2;
            resize(newInitialCapacity);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry nextEntry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, nextEntry);
        size++;
    }
}
