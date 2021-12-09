package com.james.algorithm.mycase;


class TwoPoint {

    public static void main(String[] args) {
        int i = maxArea(new int[]{1,1000,1000,6,2,5,4,8,3,7});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        /**
         * 步骤
         * 1 两个指针分别指向开头和末尾
         * 2 移动较小的指针
         * 3 直到两指针相遇
         */

        int left = 0;
        int right = height.length - 1;
        int initHigh = Math.min(height[left], height[right]);
        int initArea = (right - left) * initHigh;
        while (left<right){
            int leftHigh = height[left];
            int rightHigh = height[right];
            if (leftHigh<=rightHigh){
                left++;
               int areaTmp = (right - left) * (Math.min(height[left], rightHigh));
                initArea = Math.max(areaTmp,initArea);
            }

            if (leftHigh>rightHigh){
                right--;
                int areaTmp = (right - left) * (Math.min(leftHigh, height[right]));
                initArea = Math.max(areaTmp,initArea);
            }
        }
        return initArea;
    }


}