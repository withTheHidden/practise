package com.james.algorithm.geek;


public class 链表 {

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
        while (i<k&&i<s.length()&&k>=0){
            char aChar = chars[i];
            char bChar = chars[k];
            if (!Character.isLetterOrDigit(aChar)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(bChar)){
                k--;
                continue;
            }
            if (Character.toLowerCase(aChar)!=Character.toLowerCase(bChar)) {
                return false;
            }
            i++;
            k--;
        }
    return true;
    }

}