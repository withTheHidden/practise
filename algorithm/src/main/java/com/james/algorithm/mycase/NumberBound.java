package com.james.algorithm.mycase;

import java.util.*;

public class NumberBound {

    //所有组合一般想到 回溯法,虽然我的方法也很新颖
    public static void main(String[] args) {
        List<String> bound = bound2("2");
        System.out.println(bound);
    }


    //回溯法速度快
    List<String> res = new LinkedList<>();
    String[] letterMap = {" ","*", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }

    private void iterStr(String digits, StringBuilder stringBuilder, int index) {
        if (digits.length() == index) {
            res.add(stringBuilder.toString());
            return;
        }
        char c = digits.charAt(index);
        int point = c - '0';
        String map_string = letterMap[point];

        for (int i = 0; i < map_string.length(); i++) {
            stringBuilder.append(map_string.charAt(i));
            iterStr(digits, stringBuilder, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }



    //my

    static HashMap<String, String[]> map = new HashMap<String, String[]>() {{
        put("1", new String[]{""});
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "o", "n"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};



    public static List<String> bound2(String s) {
        LinkedList<String> list = new LinkedList<>();
        if (null == s || "1".equals(s)) {
            list.add("");
            return list;
        }
        if (s.length() == 1) {
            return Arrays.asList(map.get(s));
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ('1' == chars[i]) {
                continue;
            }
            String[] strings = map.get(String.valueOf(chars[i]));

            if (i == 0) {
                Collections.addAll(list, strings);
            } else {
                LinkedList<String> listTmp = new LinkedList<>();
                for (String now : list) {
                    for (String toAdd : strings) {
                        listTmp.add(now + toAdd);
                    }
                }
                list = listTmp;
            }

        }

        return list;


    }

}
