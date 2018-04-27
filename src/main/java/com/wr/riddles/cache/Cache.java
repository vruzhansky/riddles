package com.wr.riddles.cache;

public interface Cache<K, V> {
    void add(K key, V value);

    void remove(K key);

    V get(K key);
}
