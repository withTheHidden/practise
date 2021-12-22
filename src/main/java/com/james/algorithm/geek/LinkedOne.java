package com.james.algorithm.geek;


import java.util.HashSet;
import java.util.LinkedList;

public class LinkedOne {

}

class huiwen {
    //判断回文串
    public static void main(String[] args) {
        String s = "abc:: Cba";
        System.out.println(test(s));
    }

    private static boolean test(String s) {
        char[] chars = s.toCharArray();
        int k = s.length() - 1;
        int i = 0;
        while (i < k && i < s.length() && k >= 0) {
            char aChar = chars[i];
            char bChar = chars[k];
            if (!Character.isLetterOrDigit(aChar)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(bChar)) {
                k--;
                continue;
            }
            if (Character.toLowerCase(aChar) != Character.toLowerCase(bChar)) {
                return false;
            }
            i++;
            k--;
        }
        return true;
    }

}

class Link {
    Character value;
    Link next;

    public Link() {
    }

    public Link(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getLength() {
        Link tmp = this;
        int size = 1;
        while (tmp.next != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    @Override
    public String toString() {
        Link tmp = next;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(value));
        while (tmp!=null){
            stringBuilder.append(" ").append(tmp.getValue());
            tmp=tmp.next;
        }
        return stringBuilder.toString();
    }

}

//单链表判断回文
class SingleLinked {


    public static void main(String[] args) {
        Link link = new Link('1');
        link.next = new Link('2');
        link.next.next = new Link('3');
        link.next.next.next = new Link(':');

        link.next.next.next.next = new Link('3');
        link.next.next.next.next.next = new Link('2');
        link.next.next.next.next.next.next = new Link('1');


        System.out.println(test(link));
    }

    private static boolean test(Link s) {
        Link fast = s;
        Link slow = s;
        Link pre = null;

        boolean one = false;
        int length = s.getLength();
        if (s.getLength() % 2 == 1) {
            one = true;
        }
        while (fast.next != null) {
            if (pre == null) {
                pre = slow;
                slow = slow.next;
            } else {
                Link tmp = slow;
                slow = slow.next;
                tmp.next = pre;
                pre = tmp;
            }
            fast = fast.next.next;
        }
        if (one) {
            slow = slow.next;
        }
        while (slow.next != null) {
            if (pre.getValue() != slow.getValue()) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}

//简单版本
class LRU {
    LinkedList<Object> list = null;
    HashSet<Object> hsah = new HashSet<Object>();
    final int cap;
    int size = 0;

    public LRU(int cap) {
        this.cap = cap;
    }

    public synchronized void add(Object event) {
        if (size > cap) {
            list.removeLast();
            list.addFirst(event);
            size++;
            return;
        }
        if (hsah.contains(event)) {
            list.remove(event);
            list.addFirst(event);
        } else {
            list.addFirst(event);
            size++;
        }
    }

    public synchronized Object remove() {
        return list.removeFirst();
    }

}
//翻转
class reverseLink {
    public static void main(String[] args) {
        Link link = new Link('1');
        link.next = new Link('2');
        link.next.next = new Link('3');
        link.next.next.next = new Link(':');
        link = test(link);
        while (link != null) {
            System.out.print(link.getValue());
            link = link.next;
        }
    }

    private static Link test(Link link) {
        Link head = new Link();
        head.next = link;
        while (link.next != null) {
            Link tmp = link.next;
            link.next = link.next.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }

}
// 环
class circle{
    public static void main(String[] args) {
        Link link = new Link('1');
        link.next = new Link('2');
        link.next.next = new Link('3');
        boolean a = test(link);
        System.out.println(a);

    }

    private static boolean test(Link link) {
        if (link == null||link.next==null){
            return false;
        }
    Link slow = link;
    Link faster = link;
    while (faster!=null&&faster.next!=null){
        faster=faster.next.next;
        slow=slow.next;
        if (faster==slow){
            return true;
        }
    }
    return false;
    }

}

class linkTwoLink{
    public static void main(String[] args) {
        Link link = new Link('1');
        link.next = new Link('2');
        link.next.next = new Link('4');

        Link link1 = new Link('1');
        link1.next = new Link('3');
        link1.next.next = new Link('4');

        Link test = test(link1, link);
        System.out.println(test);

    }

    private static Link test(Link link, Link link1) {

        if (link==null||link1==null){
            return link==null?link1:link;
        }

        Link first = link;
        Link second = link1;

        Link result = new Link();
        Link resultPoint = result;

        while (first!=null&& second!=null){

            if (first.getValue()-'0'>=second.getValue()-'0'){
                resultPoint.setNext(second);
                second =second.next;
            } else {
                resultPoint.setNext(first);
                first=first.next;
            }
            resultPoint = resultPoint.next;
        }

        if (first==null){
            resultPoint.next = second;
        }else {
            resultPoint.next = first;
        }

        return result.next;
    }
}

//删除倒数第n个节点
class deleteBackNumberNode{
    public static void main(String[] args) {
        Link link = new Link('1');
        link.next = new Link('2');
        link.next.next = new Link('4');



        Link test = test( link,4);
        System.out.println(test);

    }

    private static Link test(Link link,int number) {
        if (link==null||link.next==null){
            return null;
        }
        if (number==0){
            return link;
        }
        Link fast = link;
        Link slow = link;
        int num =number;
        while (num>1){
            fast =fast.next;
            num--;
        }
        if (fast==null){
            return link;
        }

        Link tmp = slow;
        while (fast.next!=null){
            fast =fast.next;
            tmp = slow;
            slow = slow.next;
        }
        if (tmp==slow){
            link = link.next;
        }else
       tmp.setNext(slow.next);
        return  link;


    }
}