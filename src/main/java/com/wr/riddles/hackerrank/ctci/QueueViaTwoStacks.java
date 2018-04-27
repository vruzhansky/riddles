package com.wr.riddles.hackerrank.ctci;

import java.util.Scanner;
import java.util.Stack;

public class QueueViaTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    static class MyQueue<T> {
        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();

        void enqueue(T e) {
            in.push(e);
        }

        void dequeue() {
            moveElementsToOut();
            out.pop();
        }

        T peek() {
            moveElementsToOut();
            return out.peek();
        }

        private void moveElementsToOut() {
            if (out.isEmpty()) {
                while (in.size() > 0) {
                    out.push(in.pop());
                }
            }
        }
    }
}
