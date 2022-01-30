package com.james.algorithm.mycase;

import java.util.List;

public class TwoLinkAdd {
    public static void main(String[] args) {
        ListNode listNode = add2(new ListNode(9,9,9,9,9,9,9), new ListNode(9,9,9,9));
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        add(l1, l2, node, 0);
        return node;
    }

    private static void add(ListNode l1, ListNode l2, ListNode node, int ad) {
        node.val = (l1.val + l2.val) % 10 + ad;
        if (l1.val + l2.val > 9) {
            ad = 1;
        } else {
            ad = 0;
        }
        if (l1.next != null && l2.next != null) {
            node.next = new ListNode();
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
            add(l1, l2, node, ad);
        }
        if (l1.next == null && l2.next == null) {
            return;
        }
        if (null != l1.next) {
            node.next = l1.next;
        }
        if (null != l2.next) {
            node.next = l2.next;
        }

    }

    private static ListNode add2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode listNode = new ListNode();
        ListNode head = new ListNode();
        head.next = listNode;

        int add = 0;
        while (null != l1 && null != l2) {
            int sumTmp = l1.val + l2.val + add;
            listNode.val = sumTmp % 10;
            add = sumTmp / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (null == l1 || null == l2) {
                continue;
            }
            listNode.next = new ListNode();
            listNode = listNode.next;
        }
        if (l1 != null) {
            while (null != l1){
                listNode.next = new ListNode();
                listNode = listNode.next;
                int sumTmp = l1.val + add;
                listNode.val = sumTmp % 10;
                add = sumTmp / 10;
                l1 = l1.next;

            }
        }
        if (l2 != null) {
            while (null != l2){
                listNode.next = new ListNode();
                listNode = listNode.next;
                int sumTmp = l2.val + add;
                listNode.val = sumTmp % 10;
                add = sumTmp / 10;
                l2 = l2.next;
            }
        }
        if (add!=0){
            listNode.next = new ListNode(add);
        }

        return head.next;
    }


}


//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int q, int b, int c,int d,int e ,int f ,int g) {
        val = q;
        next = new ListNode(b);
        next.next = new ListNode(c);
        next.next.next = new ListNode(d);
        next.next.next.next = new ListNode(e);
        next.next.next.next.next = new ListNode(f);
        next.next.next.next.next.next = new ListNode(g);
    }
    ListNode(int q, int b, int c,int d) {
        val = q;
        next = new ListNode(b);
        next.next = new ListNode(c);
        next.next.next = new ListNode(d);

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(val));
        ListNode node = next;
        while (node!=null){
            stringBuilder.append(node.val);
            node = node.next;
        }
        return stringBuilder.toString();
    }
}