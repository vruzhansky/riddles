package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;

import java.util.HashMap;
import java.util.Map;

public class LinkedListBasedLFUCache<K, V> implements Cache<K, V> {
    private final int size;
    private final Map<K, Entry<K, V>> cache = new HashMap<>();
    private FrequencyNode<K, V> frequencies;

    public LinkedListBasedLFUCache(int size) {
        this.size = size;
    }

    @Override
    public void add(K key, V value) {
        if (cache.size() >= size) {
            cache.remove(frequencies.firstEntry.key);
            if (frequencies.lastEntry == frequencies.firstEntry) {
                frequencies.lastEntry = frequencies.firstEntry.next;
            }
            frequencies.firstEntry = frequencies.firstEntry.next;
        }
        wrapAndPut(key, value);
    }

    private void wrapAndPut(K key, V value) {
        Entry<K, V> entry;

        if (cache.containsKey(key)) {
            Entry<K, V> oldEntry = cache.get(key);
            queue.remove(oldEntry);
            entry = new Entry<>(key, value, oldEntry.frequencyNode++);
        } else {
            entry = new Entry<>(key, value);
            if (frequencies.frequency == 0) {
                entry.frequencyNode = frequencies;
                entry.prev = frequencies.lastEntry;

                frequencies.lastEntry.next = entry;
            } else {
                FrequencyNode<K, V> freq = new FrequencyNode<>(0, entry);
                freq.next = frequencies;

                entry.frequencyNode = freq;

                frequencies = freq;
            }
        }

        cache.put(key, entry);
        queue.add(entry);
    }

    @Override
    public void remove(K key) {
        Entry<K, V> removedEntry = cache.remove(key);
        if (removedEntry != null) {
            removedEntry.remove();
            FrequencyNode<K, V> removedFrequencyNode = removedEntry.frequencyNode;
            if (removedFrequencyNode.isEmpty()) {
                removedFrequencyNode.remove();
                if (removedFrequencyNode == frequencies) {
                    frequencies = removedFrequencyNode.next;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = cache.get(key);
        if (entry != null) {
            if (entry.frequencyNode.next != null) {

            }
        } else {
            return null;
        }
    }

    private abstract static class DoublyLinkedList<T extends DoublyLinkedList<T>> {
        protected T prev, next;

        @SuppressWarnings("unchecked")
        protected void add(T node) {
            if (next != null) {
                this.next = node;
                node.prev = (T) this;
            }
        }

        protected void remove() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
        }
    }

    private static class FrequencyNode<K, V> extends DoublyLinkedList<FrequencyNode<K, V>> {
        private final int frequency;

        private Entry<K, V> firstEntry;

        private FrequencyNode(int frequency, Entry<K, V> entry) {
            this.frequency = frequency;
            this.firstEntry = entry;
            entry.frequencyNode = this;
        }

        private boolean isEmpty() {
            return firstEntry == null;
        }
    }

    private static class Entry<K, V> extends DoublyLinkedList<Entry<K, V>> {
        private final K key;
        private final V value;

        private FrequencyNode<K, V> frequencyNode;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private V get() {
            FrequencyNode<K, V> nextFrequencyNode = frequencyNode.next;
            if (nextFrequencyNode != null) {
                if (nextFrequencyNode.frequency == frequencyNode.frequency + 1) {
                    attachTo(nextFrequencyNode.lastEntry);
                } else {
                    FrequencyNode<K, V> newFrequencyNode = new FrequencyNode<>(frequencyNode.frequency + 1, this);
                    frequencyNode.add(newFrequencyNode);
                }
            }

            return value;
        }

        private void moveToFrequencyNode(FrequencyNode<K, V> newFreqNode) {
            if (this.prev != null) {
                this.prev.next = this.next;
            } else {
                // means it is firstEntry
                this.frequencyNode.firstEntry = this.next;
            }
            newFreqNode.
                    this.prev = null;
            this.next = null;
        }

        private void attachTo(Entry<K, V> to) {
            this.prev = to;
            to.next = this;
        }
    }
}
