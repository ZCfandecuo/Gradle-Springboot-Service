package com.johnny.singlegradlespringboot.service;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] state = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int[] dist = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 计算所有相邻系统的总长度
        long totalAll = 0;
        for (int i = 0; i < n - 1; i++) {
            totalAll += dist[i + 1] - dist[i];
        }

        // 2. 收集所有开机系统的索引
        List<Integer> onIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (state[i] == 1) {
                onIndices.add(i);
            }
        }

        // 3. 计算开机系统之间的最大间隙（不需要连接的最长边）
        long maxOnGap = 0;
        for (int i = 0; i < onIndices.size() - 1; i++) {
            int startIdx = onIndices.get(i);
            int endIdx = onIndices.get(i + 1);
            long gap = dist[endIdx] - dist[startIdx];
            if (gap > maxOnGap) {
                maxOnGap = gap;
            }
        }

        // 4. 结果 = 总长度 - 最大间隙
        long result = totalAll - maxOnGap;
        System.out.println(result);
    }
}