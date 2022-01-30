package com.james.algorithm.mycase;

public class ExchangeBetweenNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, 1, 3, 4);
        String s = listNode.toString();
        System.out.println(listNode);
        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next=head;
        return node;
    }
}
