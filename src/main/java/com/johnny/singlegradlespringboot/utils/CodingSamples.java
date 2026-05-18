package com.johnny.singlegradlespringboot.utils;


import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CodingSamples {
    public static void main(String[] args) {
        //当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

        //例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
//List<Integer> res = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String res = in.next();

            ExecutorService executor = Executors.newFixedThreadPool(5);
            //1、使用runAsync或supplyAsync发起异步调用
            CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() ->
                    res, executor);
            //2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
            CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result 2");
            //3、先初始化一个未完成的CompletableFuture，然后通过complete() completeExceptionally()，完成该CompletableFuture
            CompletableFuture<String> cf = new CompletableFuture<>();
            cf.complete("Final success");
            CompletableFuture<String> cf3 = cf1.thenApply(result1 -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Success result 3";
            });
            CompletableFuture<String> cf5 = cf2.thenApply(result1 -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Success result 5";
            });

            CompletableFuture<String> cf4 = cf1.thenCombine(cf2, (res1, res2) -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Success result 4";
            });
            CompletableFuture.allOf(cf3, cf4, cf5);
//            nextRow(res);
        }
    }

    public static List<Integer> stock(List<Integer> stocks){
        List<Integer> ans = new LinkedList<>();
        Deque<Integer> res = new LinkedList<>();
        for (int i = 0; i < stocks.size(); i++) {
            while (!res.isEmpty()&&stocks.get(i)>=stocks.get(res.peek())){
                Integer value = res.poll();
                ans.add(i-value);
            }
            res.push(i);
        }
        return ans;
    }
}
