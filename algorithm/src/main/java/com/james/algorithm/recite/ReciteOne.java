package com.james.algorithm.recite;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ReciteOne {
    private static AtomicInteger time = new AtomicInteger(0);
    private static volatile int flag = 0;
    private static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,5, TimeUnit.SECONDS, new LinkedBlockingDeque(5));

    public static void main(String[] args) {
        solution();
    }
   static void solution() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (time.get() <= 100) {
                    if (flag == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + time);
                        flag = 1;
                        time.incrementAndGet();
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (time.get() <= 100) {

                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + time);
                        flag = 2;
                        time.incrementAndGet();
                    }
                }
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                while (time.get() <= 100) {
                    if (flag == 2) {
                        System.out.println(Thread.currentThread().getName() + ": " + time);
                        flag = 0;
                        time.incrementAndGet();
                    }
                }
            }
        };
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable2);
        threadPoolExecutor.submit(runnable3);
    }
}
