package com.james.algorithm.geek;


import java.util.*;

public class Stack {
    //栈 '('，')'，'{'，'}'，'['，']'
    public static void main(String[] args) {
        String string = ")";
        boolean result = test(string);
        System.out.println(result);
    }

    static Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    private static boolean test(String string) {
        LinkedList<Character> list = new LinkedList<>();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                list.addFirst(c);
            } else {
                if (list.size() == 0) {
                    return false;
                }
                Character toCheck = map.get(list.removeFirst());
                if (c != toCheck) {
                    return false;
                }
            }
        }
        return list.size() == 0;
    }

}

//实现一个 查询最小数字为O(1)的栈
class MinStack {

    LinkedList<Integer> list;
    Integer min = null;

    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int val) {

        list.add(val);
        if (null == min || getMin() > val) {
            min = val;
        }
    }

    public void pop() {
        Integer remove = list.removeLast();
        if (remove.equals(min)){

            if (list.size()!=0){
                min=list.get(0);
            }else {
                min=null;
                return;
            }
            for (Integer integer : list) {
                if (min > integer) {
                    min = integer;
                }
            }
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return min;
    }

}
class MinStackTest{
    public static void main(String[] args) {
        MinStack minStackTest = new MinStack();
        minStackTest.push(2147483646);
        minStackTest.push(2147483646);
        minStackTest.push(2147483647);
        minStackTest.top();
        minStackTest.pop();
        minStackTest.getMin();
        minStackTest.pop();
        minStackTest.getMin();
        minStackTest.pop();
        minStackTest.push(2147483647);

        minStackTest.top();
        minStackTest.getMin();

        minStackTest.push(-2147483648);
        minStackTest.top();
        minStackTest.getMin();
        minStackTest.pop();
        minStackTest.getMin();
    }
}

