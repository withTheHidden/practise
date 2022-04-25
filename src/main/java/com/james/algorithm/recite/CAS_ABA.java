package com.james.algorithm.recite;

import org.springframework.aop.ThrowsAdvice;

import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS_ABA {
    private static final AtomicStampedReference<Integer> atom =new AtomicStampedReference<Integer>(0,0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //业务代码
                atom.compareAndSet(0,1,0,  1);

                boolean b = atom.compareAndSet(1, 0, 1, 2);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atom.getStamp();
                atom.compareAndSet(0,1,0, stamp +1);
                //业务代码
                atom.compareAndSet(1,0,stamp+1,stamp+2);
            }
        }).start();

    }
}
