package com.johnny.singlegradlespringboot.utils;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        boolean[] t = new boolean[n + 1];
        for (int i = 0; i < k; i++) t[sc.nextInt()] = true;

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            g[u].add(v); g[v].add(u);
        }

        if (k == 0) { System.out.println(0); return; }

        int s = 1; while (!t[s]) s++;
        int[] r1 = bfs(s, n, g, t);
        int[] r2 = bfs(r1[0], n, g, t);
        System.out.println(r2[1]);
    }

    static int[] bfs(int s, int n, List<Integer>[] g, boolean[] t) {
        int[] d = new int[n + 1], p = new int[n + 1];
        Arrays.fill(d, -1); Arrays.fill(p, -1);
        Queue<Integer> q = new LinkedList<>();
        d[s] = 0; q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) if (d[v] == -1) {
                d[v] = d[u] + 1;
                p[v] = u;
                q.add(v);
            }
        }

        int far = s;
        for (int i = 1; i <= n; i++) if (t[i] && d[i] > d[far]) far = i;

        int cnt = 0, cur = far;
        while (cur != -1) { if (t[cur]) cnt++; cur = p[cur]; }
        return new int[]{far, cnt};
    }
}