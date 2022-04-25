package com.james.algorithm.mycase;

public class MaxLength {
    public static void main(String[] args) {
        String bab = longestPalindrome("ababa");
        System.out.println(bab);
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        //状态数组 , 行表示长度,列表从第几个数字开始
        boolean[][] arr = new boolean[chars.length+1][chars.length];
        //初始化数组,单个字母肯定为回文串.第一行不需要
        for (int i = 0; i < chars.length; i++) {
            arr[0][i] = true;
            arr[1][i] = true;
        }
        int maxLength = 0;
        int resultLeft = 0;
        int resultRight = 0;
        //遍历长度
        for (int len = 2; len <= chars.length; len++) {
            //遍历下标
            for (int left = 0; left + len - 1 < chars.length; left++) {
                //确定right下标
                int right = left + len - 1;

                //两个下标数字是否相等
                if (!(chars[left] == chars[right])) {
                    //left到right肯定不是回文串
                    continue;
                } else if (len <= 3) {
                    arr[len][left] = true;
                } else {
                    arr[len][left] = arr[len - 2][left + 1];
                }

                if (true == arr[len][left] && len > maxLength) {
                    maxLength = len;
                    resultLeft = left;
                    resultRight = right;
                }

            }
        }
        //左闭右开
        return s.substring(resultLeft, resultRight + 1);
    }
}
