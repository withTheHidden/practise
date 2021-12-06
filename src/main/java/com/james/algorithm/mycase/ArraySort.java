package com.james.algorithm.mycase;

import java.util.Arrays;
import java.util.Collections;

public class ArraySort {
    //!!
    // 注意牵扯到数组的时候,使用下标相加是错误的,因为如果两个容量为1 的数组组合成一个大数组.较大的数字下标使用 0+0 =0 是错误的
    // 对于数组,终止条件非常重要
    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 0, 0};
        int[] ints1 = {2, 4};
//        double medianSortedArrays = findMedianSortedArrays(ints1, ints);
        sort(ints, ints1, 3, 2);

    }

    //    public static double sort(int[] nums1, int[] nums2) {
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int[] merger = new  int[length1 + length2];
//        int i = 0;
//        int k = 0;
//        int cur;
//        while (i< length1 ||k< length2){
//            if (i==length1){
//                cur = nums2[k];
//                k++;
//            }else if (k==length2){
//                cur = nums1[i];
//                i++;
//            }else if (nums1[i]<nums2[k]){
//                cur=nums1[i];
//                i++;
//            }else {
//                cur=nums2[k];
//                k++;
//            }
//            merger[i+k-1]=cur;
//        }
//
//        if(merger.length%2==0){
//            return (merger[(length1+length2)/2-1]+merger[(length1+length2)/2])/2.0;
//        }else {
//            return merger[(length1+length2)/2];
//        }
//    }
    //逆向
    public static int[] sort(int[] nums1, int[] nums2, int length1, int length2) {
        int i = length1 ;
        int k = length2 ;

        int cur;
        while (i > 0 || k > 0) {
            if (i == 0) {
                cur = nums2[k-1];
                k--;
            } else if (k == 0) {
                cur = nums1[i-1];
                i--;
            } else if (nums1[i-1] > nums2[k-1]) {
                cur = nums1[i-1];
                i--;
            } else {
                cur = nums2[k-1];
                k--;
            }
            System.out.println((i-1) + ":" + (k-1));

            nums1[i + k] = cur;
        }

        System.out.println(Arrays.toString(nums1));
        return nums1;
    }
}
