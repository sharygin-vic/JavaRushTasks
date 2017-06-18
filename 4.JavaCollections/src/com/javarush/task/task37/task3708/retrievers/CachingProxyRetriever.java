package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by dell on 19-Jun-17.
 */
// vic :
public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache = new LRUCache<Long, Object>(16);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object res = lruCache.find(id);
        if (res == null) {
            res = originalRetriever.retrieve(id);
            lruCache.set(id, res);
        }
        return res;
    }
}
