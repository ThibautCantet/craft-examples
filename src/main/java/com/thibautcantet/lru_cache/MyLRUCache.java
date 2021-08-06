package com.thibautcantet.lru_cache;

import java.util.HashMap;

public class MyLRUCache implements LRUCache {

    private final HashMap<Integer, Integer> hashMap;
    private final int capacity;
    private Integer lastEntry;

    public MyLRUCache(int capacity) {
        this.hashMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public HashMap<Integer, Integer> getHashMap() {
        return hashMap;
    }

    @Override
    public int get(int key) {
        final Integer result = hashMap.getOrDefault(key, -1);
        hashMap.remove(key);
        return result;
    }

    @Override
    public void set(int key, int value) {
        if (hashMap.size() == capacity) {
            hashMap.remove(lastEntry);
        }
        this.lastEntry = key;
        hashMap.put(key, value);
    }
}
