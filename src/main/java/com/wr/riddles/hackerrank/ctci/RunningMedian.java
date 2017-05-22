package com.wr.riddles.hackerrank.ctci;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * For the first two elements add smaller one to the maxHeap on the left, and bigger one to the minHeap on the right.
 * Then process stream data one by one,
 * Step 1: Add next item to one of the heaps
 * <p>
 * if next item is smaller than maxHeap root add it to maxHeap,
 * else add it to minHeap
 * <p>
 * Step 2: Balance the heaps (after this step heaps will be either balanced or
 * one of them will contain 1 more item)
 * <p>
 * if number of elements in one of the heaps is greater than the other by
 * more than 1, remove the root element from the one containing more elements and
 * add to the other one
 * Then at any given time you can calculate median like this:
 * <p>
 * If the heaps contain equal amount of elements;
 * median = (root of maxHeap + root of minHeap)/2
 * Else
 * median = root of the heap with more elements
 */
public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int next = in.nextInt();
            Integer peek = maxHeap.peek();

            if (peek == null || next < peek) maxHeap.add(next);
            else minHeap.add(next);

            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }

            double median;
            if (maxHeap.size() > minHeap.size()) {
                median = maxHeap.peek();
            } else if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else {
                median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
            System.out.println(median);
        }
    }

    static class MinIntHeap {
        private int capacity = 10;
        private int size = 0;

        int[] items = new int[capacity];

        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        private int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        private int parent(int index) {
            return items[getParentIndex(index)];
        }

        private void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        private void ensureCapacity() {
            if (size == capacity) {
                items = Arrays.copyOf(items, capacity * 2);
                capacity *= 2;
            }
        }

        public int peek() {
            if (size == 0) {
                throw new IllegalStateException();
            }
            return items[0];
        }

        public int poll() {
            if (size == 0) {
                throw new IllegalStateException();
            }
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        public void add(int item) {
            ensureCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }

                if (items[index] < items[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }

        public double median() {
            if (size < 1) {
                throw new IllegalStateException();
            }
            if (size == 1) {
                return items[0];
            }
            if (size % 2 == 1) {
                return items[size / 2];
            }
            return (double) (items[size / 2] + items[size / 2 - 1]) / 2;
        }
    }
}
