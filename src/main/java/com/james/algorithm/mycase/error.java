package com.james.algorithm.mycase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class error {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("2");
        System.out.println(strings);
    }

    static List<String> res = new LinkedList<>();
    static String[] letterMap = {" ","*", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String str) {
        if (null == str || str.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(str, new StringBuilder(), 0);
        return res;
    }


    private static void iterStr(String str, StringBuilder stringBuilder, int index) {
        if (str.length() == index) {
            res.add(stringBuilder.toString());
            return;
        }
        char c = str.charAt(index);
        int point = c - '0';
        String map_string = letterMap[point];

        for (int i = 0; i < map_string.length(); i++) {
            stringBuilder.append(map_string.charAt(i));
            iterStr(str, stringBuilder, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }
}
