package com.thibautcantet.lru_cache;

public interface LRUCache {
    int get(int key);
    void set(int key, int value);
}
