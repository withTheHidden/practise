package com.james.algorithm.mycase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
//        int t = 5;
//        int[] ints = twoSum(a, 5);
//        System.out.println(Arrays.toString(ints));
        int a = 0;
        int b =3;
        swap(arr,a,b);

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[]{i, map.get(k)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1};
    }

    private static void swap(int []arr,int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
