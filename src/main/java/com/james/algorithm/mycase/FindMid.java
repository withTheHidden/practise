package com.james.algorithm.mycase;

public class FindMid {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1,2,3,6,7,8}, new int[]{4, 5});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //找到两个数组的中位数, 较大数字下标是大指针,较小的数字下标是小指针
        //小指针+1的数字 *2 小于两个中位数之合则移动
        //大指针-1的数字 /2 大于两个中位数之和则移动
        //小指针要小于等于大指针,否则跳出
        int length1 = nums1.length-1;
        int length2 = nums2.length-1;

        int left1 = length1 / 2;
        int left2 = length2 / 2;
        if (nums1[left1] >= nums2[left2]) {
            return find(nums2, nums1, left2, left1);
        } else if (nums1[left1] < nums2[left2]) {
            return find(nums1, nums2, left1, left2);
        } else {
            return nums1[left1];
        }

    }

    private static double find(int[] arr1, int[] arr2, int left1, int left2) {
        while (arr1[left1] < arr2[left2]) {
            int tmp1 = arr1[left1];
            int tmp2 = arr2[left2];
            int sum = tmp1 + tmp2;

            if (tmp1 * 2 <= sum ) {
                left1++;
                if (left1>arr1.length-1){
                    return ((double) (arr1[arr1.length-1] + arr2[left2])) / 2.0;
                }
            }
            if (tmp2 * 2 > sum ) {
                left2--;
                if (left2<0){
                    return ((double) (arr1[left1] + arr2[0])) / 2.0;
                }

            }
        }
        return ((double) (arr1[left1] + arr2[left2])) / 2.0;
    }
}
