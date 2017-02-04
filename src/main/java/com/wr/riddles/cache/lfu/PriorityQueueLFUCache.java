package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueLFUCache<K, V> implements Cache<K, V> {
    private final int size;
    private final Map<K, Entry<K, V>> cache = new HashMap<>();
    private final Queue<Entry<K, V>> queue = new PriorityQueue<>();

    public PriorityQueueLFUCache(int size) {
        this.size = size;
    }

    @Override
    public void add(K key, V value) {
        if (cache.size() >= size) {
            Entry<K, V> head = queue.remove();
            cache.remove(head.key);
        }
        wrapAndPut(key, value);
    }

    private void wrapAndPut(K key, V value) {
        Entry<K, V> entry;

        if (cache.containsKey(key)) {
            Entry<K, V> oldEntry = cache.get(key);
            queue.remove(oldEntry);
            entry = new Entry<>(key, value, oldEntry.frequency++);
        } else {
            entry = new Entry<>(key, value);
        }

        cache.put(key, entry);
        queue.add(entry);
    }

    @Override
    public void remove(K key) {
        Entry<K, V> removedEntry = cache.remove(key);
        if (removedEntry != null) {
            queue.remove(removedEntry);
        }
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = cache.get(key);
        if (entry != null) {
            V value = entry.get();
            queue.remove(entry);
            queue.add(entry);
            return value;
        } else {
            return null;
        }
    }

    private static class Entry<K, V> implements Comparable<Entry<K, V>> {
        private final K key;
        private final V value;
        private int frequency;

        private Entry(K key, V value) {
            this(key, value, 0);
        }

        private Entry(K key, V value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

        private V get() {
            frequency++;
            return value;
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return this.frequency < o.frequency ? -1 :
                    this.frequency > o.frequency ? 1 : 0;
        }
    }
}
