package com.james.algorithm.mycase;

import org.springframework.util.CollectionUtils;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class SimpleLock {
    private volatile AtomicReference<Thread> lock = new AtomicReference<Thread>();
    private volatile LinkedBlockingDeque<Thread> waiters = new LinkedBlockingDeque<>();

    public void lock() {
        while (!tryLock()) {
            waiters.add(Thread.currentThread());
            LockSupport.park();
        }
        waiters.remove(Thread.currentThread());
    }

    public boolean tryLock() {
        return lock.compareAndSet(null, Thread.currentThread());
    }

    public void unlock() {
        if (lock.compareAndSet(Thread.currentThread(), null)) {
            if (CollectionUtils.isEmpty(waiters)) {
                waiters.stream().forEach(waiter -> {
                    LockSupport.unpark(waiter);
                });
            }
        }
    }

}
