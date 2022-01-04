package com.james.algorithm.geek;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue {
    public static void main(String[] args) {


        //	测试用例:["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
        //				[[3],[1],[2],[3],[4],[],[],[],[4],[]]
        //				测试结果:[null,true,true,true,false,1,true,true,true,2]
        //				期望结果:[null,true,true,true,false,3,true,true,true,4]
        MyCircularQueueCurrent circularQueue = new MyCircularQueueCurrent(600);
        Runnable runnable = () -> {
            int i1 = 0;
            while (i1 < 100) {
                circularQueue.enQueue(i1);
                i1++;
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        System.out.println(circularQueue);

    }

}

// 数组循环队列
class MyCircularQueue {
    private int[] items;
    private int cap = 0;
    private int head = 0;
    private int tail = 0;

    public MyCircularQueue(int k) {
        k = k + 1;
        items = new int[k];
        cap = k;
    }

    public boolean enQueue(int value) {
        if ((tail + 1) % cap == head) {
            return false;
        }
        items[tail] = value;
        tail = (tail + 1) % cap;
        return true;
    }

    public boolean deQueue() {
        if (head == tail) {
            return false;
        }
        head = (head + 1) % cap;
        return true;
    }

    public int Front() {
        if (head == tail) {
            return -1;
        }
        return items[head];
    }

    public int Rear() {
        if (head == tail) {
            return -1;
        }
        int rear = (tail + cap - 1) % cap;
        return items[rear];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % cap == head;
    }
}

// CAS的并发队列
class MyCircularQueueCurrent {
    private final int[] items;
    private int cap = 0;
    private int head = 0;
    private int tail = 0;
    private final AtomicBoolean flag;

    public MyCircularQueueCurrent(int k) {
        k = k + 1;
        items = new int[k];
        cap = k;
        flag = new AtomicBoolean(false);
    }

    public boolean enQueue(int value) {
        if (getLock() && (tail + 1) % cap == head) {
            return false;
        }

        items[tail] = value;
        tail = (tail + 1) % cap;
        flag.set(false);
        return true;
    }

    private boolean getLock() {
        int i = 0;
        while (i < 100) {
            if (flag.compareAndSet(false, true)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean deQueue() {
        if (getLock() && head == tail) {
            return false;
        }
        head = (head + 1) % cap;
        flag.set(false);
        return true;
    }

    public int Front() {
        if (head == tail) {
            return -1;
        }
        return items[head];
    }

    public int Rear() {
        if (head == tail) {
            return -1;
        }
        int rear = (tail + cap - 1) % cap;
        return items[rear];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % cap == head;
    }

    @Override
    public String toString() {
        return "MyCircularQueueCurrent{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}


