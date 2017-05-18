package com.wr.riddles.hackerrank.week32;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CircularWalk {

    static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p) {
        int[] nodes = new int[n];
        boolean[] visited = new boolean[n];
        nodes[0] = r_0;

        for (int i = 1; i < n; i++) {
            nodes[i] = (nodes[i - 1] * g + seed) % p;
        }

        if (s == t) return 0;
        if (nodes[s] == 0) return -1;

        Queue<Integer> toGo = new LinkedList<>();
        toGo.add(-1);
        toGo.add(s);
        visited[s] = true;

        int count = 0;
        do {
            int from = toGo.poll();
            if (from == -1) {
                count++;
                toGo.add(-1);
                continue;
            }

            int r = nodes[from];
            int back = (n + from - r) % n;

            for (int i = 0; i < 2 * r + 1; i++) {
                int idx = (back + i) % n;
                if (idx == t) return count;

                if (!visited[idx] && nodes[idx] != 0) {
                    toGo.add(idx);
                    visited[idx] = true;
                }
            }
        } while (!toGo.isEmpty());

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);
    }
}
