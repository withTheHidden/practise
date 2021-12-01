package com.james.algorithm.recite;

import org.springframework.util.CollectionUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

//simplelock
public class ReciteTwo {
    private static AtomicReference<Thread> lock = new AtomicReference<>();
    private static LinkedBlockingQueue<Thread> waiter = new LinkedBlockingQueue<>();

    public void lock() {
        while (!tryLock()) {
            waiter.add(Thread.currentThread());
            LockSupport.park();
            //remove需要写在循环内
            waiter.remove(Thread.currentThread());
        }
    }


    public boolean tryLock() {
        return lock.compareAndSet(null, Thread.currentThread());
    }

    public void unlock() {
        if (lock.compareAndSet(Thread.currentThread(), null)) {
            //全部唤醒
            if (!CollectionUtils.isEmpty(waiter)) {
                waiter.stream().forEach(waite -> {
                    LockSupport.unpark(waite);
                });
            }
        }
    }
}
