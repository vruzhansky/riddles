package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;

import java.util.HashMap;
import java.util.Map;

public class MapBasedLFUCache<K, V> implements Cache<K, V> {
    private final int size;
    private final Map<K, Entry<V>> cache = new HashMap<>();

    public MapBasedLFUCache(int size) {
        this.size = size;
    }

    @Override
    public void add(K key, V value) {
        if (cache.size() >= size) {
            cache.entrySet()
                    .stream()
                    .min((o1, o2) -> o1.getValue().frequency < o2.getValue().frequency ? -1 :
                            o1.getValue().frequency > o2.getValue().frequency ? +1 : 0)
                    .ifPresent(entry -> cache.remove(entry.getKey()));
        }
        wrapAndPut(key, value);
    }

    private void wrapAndPut(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, new Entry<>(value, cache.get(key).frequency++));
        } else {
            cache.put(key, new Entry<>(value));
        }
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public V get(K key) {
        Entry<V> entry = cache.get(key);
        return entry != null ? entry.get() : null;
    }

    private static class Entry<V> implements Comparable<Entry<V>> {
        private final V value;
        private int frequency;

        private Entry(V value) {
            this(value, 0);
        }

        private Entry(V value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        private V get() {
            frequency++;
            return value;
        }

        @Override
        public int compareTo(Entry<V> o) {
            return this.frequency < o.frequency ? -1 :
                    this.frequency > o.frequency ? 1 : 0;
        }
    }
}
