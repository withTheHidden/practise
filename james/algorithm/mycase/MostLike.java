package com.james.algorithm.mycase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MostLike {

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{0, 2, 5,4,3}, 13);
        System.out.println(i);
    }

    //再次优化
    public static int threeSumClosest2(int[] nums, int target) {
        List<Integer> list = new ArrayList<>(5);
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {

            int M = i + 1;
            int R = nums.length - 1;
            while (M < R) {
                int sum = nums[i] + nums[M] + nums[R];
                //核心在这里,省去了很多变量
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    M++;
                } else {
                    //sum = target
                    return ans;
                }

            }
        }
        System.out.println(list);
        return ans;
    }

    //初次优化
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        List<Integer> list = new ArrayList<>(5);
        Arrays.sort(nums);
        result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];

            int M = i + 1;
            int R = nums.length - 1;
            while (M < R) {
                int mid = nums[M];
                int right = nums[R];
                int sum = left + mid + right;
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                    list = Arrays.asList(nums[i], nums[M], nums[R]);
                }else if (sum - target > 0) {
                    R--;
                }else if (sum - target < 0) {
                    M++;
                }else if (sum == target) {
                    list = Arrays.asList(nums[i], nums[M], nums[R]);
                    return result;
                }

            }
        }
        System.out.println(list);
        return result;
    }
}