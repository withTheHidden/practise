package com.james.algorithm.mycase;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrint100 {
    private static AtomicInteger i = new AtomicInteger(0);
    private static volatile int flag = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        Runnable runnable0 = new Runnable() {
            @Override
            public void run() {
                while (i.get() < 100) {
                    if (flag == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        i.incrementAndGet();
                        flag = 1;
                    }
                }
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (i.get() < 100) {
                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        i.incrementAndGet();
                        flag = 2;
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (i.get() < 100) {
                    if (flag == 2) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        i.incrementAndGet();
                        flag = 0;
                    }
                }
            }
        };
        threadPoolExecutor.submit(runnable0);
        threadPoolExecutor.submit(runnable1);
        threadPoolExecutor.submit(runnable2);

    }
}
