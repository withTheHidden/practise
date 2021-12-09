package com.james.algorithm.mycase;
class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label) {
        this.label = label;
    }
};

public class linkedCopy {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pCur = pHead;
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        while (pCur != null) {
            if (pCur.random != null) {
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        pCur = pHead;
        RandomListNode cur = pCur.next;
        RandomListNode newhead = cur;
        while (cur != null) {
            pCur.next = cur.next;
            if (pCur.next != null) {
                cur.next = pCur.next.next;
            }
            pCur = pCur.next;
            cur = cur.next;
        }
        return newhead;
    }
}