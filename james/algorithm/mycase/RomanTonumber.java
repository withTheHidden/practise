package com.james.algorithm.mycase;

import java.util.LinkedHashMap;

public class RomanTonumber {
    public static void main(String[] args) {
        int iii = romanToInt("MCMXCIV");
        System.out.println(iii);
    }

    public static int romanToInt(String s) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>() {{
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }};
        char[] chars = s.toCharArray();

        if (s.length() == 1) {
            return map.get(s);
        }
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int k = i + 1;
            String left = String.valueOf(chars[i]);
            if (k < chars.length) {
                String right = String.valueOf(chars[k]);
                if (map.get(left) < map.get(right)) {
                    result = result + map.get(left + right);
                    i++;
                } else {
                    result = result + map.get(left);
                }
            } else {
                result = result + map.get(left);
            }
        }
        return result;
    }
}

