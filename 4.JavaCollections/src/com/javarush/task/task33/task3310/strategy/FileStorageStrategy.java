package com.javarush.task.task33.task3310.strategy;

/**
 * Created by dell on 16-Jun-17.
 */
public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (FileBucket bucket : table) {
            if (bucket != null) {
                Entry current = bucket.getEntry();
                while (current != null) {
                    if (value.equals(current.getValue())) return true;
                    current = current.next;
                }
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
        for (FileBucket bucket : table) {
            if (bucket != null) {
                Entry current = bucket.getEntry();
                while (current != null) {
                    if (value.equals(current.getValue())) {
                        return current.getKey();
                    }
                    current = current.next;
                }
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
        FileBucket bucket = table[indexFor(hash, table.length)];
        if (bucket != null) {
            Entry entry = bucket.getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) return entry;
                entry = entry.next;
            }
        }
        return null;
    }

    void resize(int newCapacity) {
        if (table.length == newCapacity) return;
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        for (FileBucket bucket : table) {
            if (bucket != null) {
                bucket.remove();
            }
        }
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        for (FileBucket bucket : table) {
            if (bucket != null) {
                Entry current = bucket.getEntry();
                while (current != null) {
                    Entry next = current.next;
                    int newIndex = indexFor(current.hash, newTable.length);
                    FileBucket bucketFromNewTable = newTable[newIndex];
                    if (bucketFromNewTable == null) {
                        bucketFromNewTable = new FileBucket();
                        newTable[newIndex] = bucketFromNewTable;
                    }
                    Entry lastEntryFromNewTable = bucketFromNewTable.getEntry();
                    current.next = lastEntryFromNewTable;
                    bucketFromNewTable.putEntry(current);
                    current = next;
                }
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket bucket = table[bucketIndex];
        if (bucket == null) {
            createEntry(hash, key, value, bucketIndex);
        }
        else {
            Entry nextEntry = bucket.getEntry();
            bucket.putEntry(new Entry(hash, key, value, nextEntry));
            if (bucket.getFileSize() > bucketSizeLimit) {
                int newInitialCapacity = table.length * 2;
                resize(newInitialCapacity);
            }
            size++;
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket bucket = new FileBucket();
        table[bucketIndex] = bucket;
        bucket.putEntry(new Entry(hash, key, value, null));
        size++;
    }



}
