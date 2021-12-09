package com.james.algorithm.mycase;

import java.util.*;

public class Unduplicated {
    public static void main(String[] args) {
        int abbcaaacbad = find2("abbcdabc");
        System.out.println(abbcaaacbad);
    }


    //基础版
    public static int  find(String str){
        char[] chars = str.toCharArray();
        List<Character> set = new LinkedList<>();

        int k = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            k=i;
            while (k<chars.length){
                if (!set.contains(chars[k])){
                    set.add(chars[k]);
                    max = Math.max(set.size(), max);
                    k++;
                }else {
                    max = Math.max(set.size(), max);
                    set.clear();
                    break ;
                }
            }
        }
        System.out.println(set);
        return max;
    }

    //优化版
    public static int  find2(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        int k = -1;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i!=0){
                set.remove(chars[i - 1]);
            }
            while (k+1<chars.length&&!set.contains(chars[k+1])){
                    set.add(chars[k+1]);
                    k++;
            }
            max = Math.max(max,set.size());
        }
        System.out.println(set);
        return max;
    }
}
