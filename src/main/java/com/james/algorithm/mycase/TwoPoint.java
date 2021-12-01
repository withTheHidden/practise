package com.james.algorithm.mycase;


class TwoPoint {

    public static void main(String[] args) {
        int i = maxArea(new int[]{2, 3, 10, 5, 7, 8, 9});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        /**
         * 步骤
         * 1 两个指针分别指向开头和末尾
         * 2 移动末尾指针,直到第一个大于
         */

        int left = 0;
        int right = height.length - 1;
        int initHigh = Math.min(height[left], height[right]);
        int initArea = (right - left) * initHigh;

        int pointLeft = 0;
        int pointRight = height.length - 1;
        int a = left;
        int b = right;
        while (pointLeft < pointRight) {
            if (b - 1 > a) {
                int tmpRightHeight = height[b - 1];
                int high = Math.min(tmpRightHeight, height[a]);
                int tmpArea = (b - 1 - a) * high;
                if (tmpArea > initArea) {
                    initArea = tmpArea;
                    b = b - 1;
                    pointRight--;

                     {
                        b = b ^ a;
                        a = a ^ b;
                        b = b ^ a;
                    }
                }
            }

            if (b + 1 < a) {
                int tmpLeftHeight = height[b + 1];
                int high = Math.min(tmpLeftHeight, height[a]);
                int tmpArea = (a - b - 1) * high;
                if (tmpArea > initArea) {
                    initArea = tmpArea;
                    b = b + 1;
                    pointLeft++;

                     {
                        b = b ^ a;
                        a = a ^ b;
                        b = b ^ a;
                    }
                }
            }



        }
        return initArea;
    }


}