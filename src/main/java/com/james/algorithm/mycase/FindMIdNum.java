package com.james.algorithm.mycase;

public class FindMIdNum {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    //因为是两个有序数组,直接 归并合并
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //用来保存合并后数据
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            //nums的数据小于nums2,则放入result数组
            if (nums1[i] < nums2[j]) {
                result[index] = nums1[i];
                index++;
                i++;
            } else {
                result[index] = nums2[j];
                index++;
                j++;
            }
        }

        //有一个数组已经完成遍历:nums1,遍nums2的数字加入result数组
        if (i >= nums1.length) {
            while (index < result.length) {
                result[index++] = nums2[j++];
            }
        } else {
            while (index < result.length) {
                result[index++] = nums1[i++];
            }
        }

        //找到中位数,偶数even,奇数odd
        boolean odd = (result.length % 2 == 1);
        //注意,此处的index = result.length
        int mid = index / 2;
        // 注意返回的是double 要除以2.0才对.
        // 注意 index = result.length,所以 mid -1
        return odd ? (result[mid]) : (result[mid - 1] + result[mid]) / 2.0;
    }

}