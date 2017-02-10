package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;

import java.util.HashMap;
import java.util.Map;

public class LinkedListBasedLFUCache<K, V> implements Cache<K, V> {
    private final int size;
    private final Map<K, Entry<K, V>> cache = new HashMap<>();
    private FrequencyNode<K, V> firstFrequency = new FrequencyNode<>(0);

    public LinkedListBasedLFUCache(int size) {
        this.size = size;
    }

    @Override
    public void add(K key, V value) {
        if (cache.size() >= size) {
            cache.remove(firstFrequency.firstEntry.key);
            firstFrequency.firstEntry.remove();
            removeFrequencyNode(firstFrequency);
        }
        wrapAndPut(key, value);
    }

    private void wrapAndPut(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);

        if (cache.containsKey(key)) {
            Entry<K, V> oldEntry = cache.get(key);
            oldEntry.remove();
            entry.frequencyNode = oldEntry.frequencyNode;
            entry.moveToNextFrequencyNode();

            removeFrequencyNode(oldEntry.frequencyNode);
        } else {
            if (firstFrequency.frequency == 0) {
                entry.frequencyNode = firstFrequency;

                entry.append(firstFrequency.firstEntry);
                firstFrequency.firstEntry = entry;
            } else {
                FrequencyNode<K, V> newFrequency = new FrequencyNode<>(0, entry);
                newFrequency.append(firstFrequency);
                firstFrequency = newFrequency;
            }
        }

        cache.put(key, entry);
    }

    @Override
    public void remove(K key) {
        Entry<K, V> removedEntry = cache.remove(key);
        if (removedEntry != null) {
            removedEntry.remove();
            removeFrequencyNode(removedEntry.frequencyNode);
        }
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = cache.get(key);
        if (entry != null) {
            entry.remove();
            entry.moveToNextFrequencyNode();
            return entry.value;
        } else {
            return null;
        }
    }

    private void removeFrequencyNode(FrequencyNode<K, V> frequencyNode) {
        if (frequencyNode.isEmpty()) {
            frequencyNode.remove();
            if (frequencyNode == firstFrequency) {
                firstFrequency = frequencyNode.next;
            }
        }
    }

    private abstract static class DoublyLinkedList<T extends DoublyLinkedList<T>> {
        protected T prev, next;

        @SuppressWarnings("unchecked")
        protected void append(T node) {
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

        private FrequencyNode(int frequency) {
            this.frequency = frequency;
        }

        private FrequencyNode(int frequency, Entry<K, V> entry) {
            this.frequency = frequency;
            this.firstEntry = entry;
            entry.frequencyNode = this;
        }

        private boolean isEmpty() {
            return firstEntry == null;
        }

        private FrequencyNode<K, V> removeEmpty() {
            if (isEmpty()) {
                remove();
                return next;
            }
            return this;
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

        private void moveToNextFrequencyNode() {
            FrequencyNode<K, V> nextFrequencyNode = frequencyNode.next;
            if (nextFrequencyNode == null) {
                frequencyNode.append(new FrequencyNode<>(frequencyNode.frequency + 1, this));
            } else {
                if (nextFrequencyNode.frequency == frequencyNode.frequency + 1) {
                    append(nextFrequencyNode.firstEntry);
                    frequencyNode = nextFrequencyNode;
                    frequencyNode.firstEntry = this;
                } else {
                    FrequencyNode<K, V> newFrequencyNode = new FrequencyNode<>(frequencyNode.frequency + 1, this);
                    frequencyNode.append(newFrequencyNode);
                }
            }
        }
    }
}
