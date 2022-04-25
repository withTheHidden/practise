package com.james.algorithm.recite;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockUtils {
    //計數器
    //将多个前置任务并行执行,完成后执行后置任务
    //注意该计数器不会自动重置为2,因此每次都要new一个新的
    public boolean CountDownLatchUtils() {
        ThreadPoolExecutor threds = new ThreadPoolExecutor(2,
                2,
                10, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        //while(条件满足时)
        while (true) {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            threds.execute(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    System.out.println("第一个前置任务执行完成: " + countDownLatch.getCount());
                }
            });
            threds.execute(() -> {
                countDownLatch.countDown();
                System.out.println("第二前置任务执行完成: " + countDownLatch.getCount());
            });
            //直到值为0
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                //log
            }
            //执行后置任务
        }
    }


    //生产者消费者简易模型  高级计数器
    //CyclicBarrier 更高级的计数器,降为0后会自动重置为初始值
    //注意如果如Demo增加了回调,则在执行了回调后才会重置为0继续下一轮. 也就是消费者阻塞生产者
    public static void CyclicBarrier() {
        AtomicInteger atom = new AtomicInteger(0);
        AtomicInteger integer = new AtomicInteger(0);
        ArrayBlockingQueue<Integer> productOne = new ArrayBlockingQueue<>(5);
        ArrayBlockingQueue<Integer> productTwo = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    Integer take = null;
                    try {
                        take = productOne.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer take1 = null;
                    try {
                        take1 = productTwo.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer a = take + take1;
                    int i = atom.incrementAndGet();
                    System.out.println("第" + i + "次消费完成");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        //两个并行的相互独立的生产者
        new Thread(() -> {
            //while(共同的前提条件满足)
            while (true) {
                try {
                    productOne.put(1);
                    System.out.println("添加了第" + integer.incrementAndGet());
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println("队列已满,等待消费中");
                }
            }
        }).start();
        new Thread(() -> {
            //while(共同的前提条件满足)
            while (true) {
                try {
                    productTwo.put(1);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println("队列已满,等待消费中");
                }
            }
        }).start();
    }


    //Semaphore 限流器
    //限制同时执行的线程数,特别当一个线程池用于多个方法时,限制执行耗时长的线程数,防止线程池资源耗尽
    public static void Semaphore() {
        AtomicInteger integer = new AtomicInteger(0);
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4,
                5, 10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy());
        //只允许有两个线程并行执行
        while (true) {
            pool.execute(() -> {
                try {
                    semaphore.acquire();
                    needLongTime(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }
    private static void needLongTime(AtomicInteger atom){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成"+atom.incrementAndGet());
        //耗时操作

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();;
    }


}
