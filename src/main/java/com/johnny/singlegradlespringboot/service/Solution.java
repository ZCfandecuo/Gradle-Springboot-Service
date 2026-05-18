package com.johnny.singlegradlespringboot.service;

import java.util.*;

public class Solution {
    static long multiply(long a, long b, long limit) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a > limit / b) {
            return limit + 1;
        }
        long value = a * b;
        return value > limit ? limit + 1 : value;
    }

    static long solve(int rows, int cols, int[][] a, int k) {
        long[] rowProduct = new long[rows];
        Arrays.fill(rowProduct, 1);

        long answer = 0;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                rowProduct[row] = multiply(rowProduct[row], a[row][col], k);
            }

            long product = 1;
            for (int row = 0; row < rows; row++) {
                product = multiply(product, rowProduct[row], k);
                if (product <= k) {
                    answer++;
                }
            }
        }

        return answer;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int rows = sc.nextInt();
//        int cols = sc.nextInt();
//
//        int[][] a = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//
//        int k = sc.nextInt();
//        System.out.println(solve(rows, cols, a, k));
//    }


    public static void hh(int[] a) {
        Scanner s = new Scanner(System.in);
        int[] c = new int[8], n = new int[8];
        for (int i = 0; i < 8; i++) c[i] = s.nextInt();
        for (int d = s.nextInt(); d-- > 0; c = n.clone())
            for (int i = 0; i < 8; i++)
                n[i] = ((i > 0 ? c[i-1] : 0) ^ (i < 7 ? c[i+1] : 0));
        for (int x : c) System.out.print(x + " ");
    }

    public static void main(String[] args) {


        int[] ints = {1, 1, 1, 0, 1, 1, 1, 1};
        hh(ints);
    }
}