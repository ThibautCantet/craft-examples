package com.thibautcantet.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRUCache implements LRUCache {
    private LinkedHashMap<Integer, Integer> cacheMap;

    public LinkedHashMapLRUCache(int capacity) {
        cacheMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    // This method works in O(1)
    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    @Override
    // This method works in O(1)
    public void set(int key, int value) {
        cacheMap.put(key, value);
    }
}
