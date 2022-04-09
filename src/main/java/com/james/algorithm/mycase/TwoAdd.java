package com.james.algorithm.mycase;

public class TwoAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers4(l1, l2);
        System.out.println(listNode);
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //判空
        if (null == l1||null ==l2){
            return l1==null?l2:l1;
        }
        //进位
        int tmp = 0;
        ListNode result = new ListNode();
        ListNode first = result;
        //先把一条链复制过来
        while (l1!=null){
            first.next = new ListNode();
            first = first.next;
            first.val = l1.val;
            l1 = l1.next;
        }
        //另外一条链相加,如果更长则继续复制
        ListNode node = result;
        while (null!= l2){
            if (node.next !=null){
                int num = l2.val + node.next.val + tmp;
                tmp = 0;
                if (num>=10){
                    num = num%10;
                    tmp  = 1;
                }
                node.next.val = num;
                node = node.next;
            }else {
                node.next = new ListNode();
                node = node.next;
                int num  = tmp + l2.val;
                tmp = 0;
                if (num>=10){
                    num = num%10;
                    tmp  = 1;
                }
                node.val = num;
            }
            l2 = l2.next;
        }

        if (tmp==1){
            node.next = new ListNode();
            node.next.val=tmp;
        }
        return result.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        //判空
        if (null == l1||null ==l2){
            return l1==null?l2:l1;
        }
        //进位
        int tmp = 0;
        ListNode result = new ListNode();
        ListNode first = result;
        //先把一条链复制过来
        while (l1!=null){
            first.next = new ListNode();
            first = first.next;
            first.val = l1.val;
            l1 = l1.next;
        }
        //另外一条链相加,如果更长则继续复制
        ListNode node = result;
        while (null!= l2){
            if (node.next !=null){
                int num = l2.val + node.next.val + tmp;
                tmp = 0;
                if (num>=10){
                    num = num%10;
                    tmp  = 1;
                }
                node.next.val = num;
                node = node.next;
            }else {
                node.next = new ListNode();
                node = node.next;
                int num  = tmp + l2.val;
                tmp = 0;
                if (num>=10){
                    num = num%10;
                    tmp  = 1;
                }
                node.val = num;
            }
            l2 = l2.next;
        }

        while (tmp == 1 && node.next != null){
            int num  = tmp + node.next.val;
            tmp = 0;
            if (num>=10){
                num = num%10;
                tmp  = 1;
            }
            node.next.val = num;
            node = node.next;
        }
        if (tmp==1){
            node.next = new ListNode();
            node.next.val=tmp;
        }
        return result.next;
    }

    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        add(l1, l2, node, 0);
        return node;
    }
    private static ListNode head;
    private static void add(ListNode l1, ListNode l2, ListNode node, int ad) {
        node.val = (l1.val + l2.val + ad) % 10 ;
        if (l1.val + l2.val + ad> 9) {
            ad = 1;
        } else {
            ad = 0;
        }
        head=l1;
        if (l1.next != null && l2.next != null) {
            node.next = new ListNode();
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
            add(l1, l2, node, ad);
        }
        System.out.println(l1);
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

}
