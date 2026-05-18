package com.johnny.singlegradlespringboot.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCode {

    public static void main(String[] args) {

        Depot depot = new Depot(500);
        new Depot.Producer(depot).produce(500);
        new Depot.Producer(depot).produce(200);
        new Depot.Consumer(depot).consume(500);
        new Depot.Consumer(depot).consume(200);
//        Lock lock = new ReentrantLock();
//
//        MyThread t1 = new MyThread("t1", lock);
//        MyThread t2 = new MyThread("t2", lock);
//        t1.start();
//        t2.start();

//        Scanner in = new Scanner(System.in);
//        ConcurrentHashMap<Object, Object> i = new ConcurrentHashMap<>();
//        i.put("a","b");
//        List<String> free = new LinkedList<>();
//        List<String> records = new LinkedList<>();
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
////            int a = in.nextInt();
////            for(int i=0;i<a;i++)
////                free.add(in.next());
////
////            records.add(in.next());
//            int m = in.nextInt();
//            int n = in.nextInt();
//            System.out.println(m+n);
//        }
//        System.out.println(free);
//        System.out.println(records);
//        System.out.println(consume(free, records));
        List<Integer> a = new LinkedList<>();
        List<List<Integer>> b = new LinkedList<>();
        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            int number = in.nextInt();
//            int days = in.nextInt();
//            for (int i = 0; i < number; i++)
//                a.add(in.nextInt());
//
//            for (int i = 0; i < days; i++) {
//                List<Integer> tmp = new LinkedList<>();
//                for (int j = 0; j < number; j++) {
//                    tmp.add(in.nextInt());
//                }
//                b.add(tmp);
//            }
//            System.out.println(a);
//            System.out.println(b);
//        }
//        int interest = interest(3, 4, new int[]{4, 5, 6}, new int[][]{{1, 2, 3,4}, {4, 3, 2,4}, {1, 5, 3,1}});
//        int interest1 = interest(1, 1, new int[]{1}, new int[][]{{1}});
//        System.out.println(interest1);
    }

    public static int interest(int number, int days, int[] item, int[][] itemPrice){
        int res= 0;
        int[][][] dp = new int[2][days][number];
        for(int i=0;i<days;i++){
            for(int j=0;j<number;j++){
                if(i==0){
                    dp[1][0][j] = -item[j]*itemPrice[j][0];
                }else{
                    dp[0][i][j] = Math.max(dp[0][i-1][j], dp[1][i-1][j]+item[j]*itemPrice[j][i]);
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[0][i-1][j]-item[j]*itemPrice[j][i]);
                }
            }
        }
        for(int i =0;i<number;i++){res += dp[0][days-1][i];}

        return res;
    }
}
