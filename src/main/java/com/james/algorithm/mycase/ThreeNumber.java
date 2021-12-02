package com.james.algorithm.mycase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeNumber {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum3(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

    //双指针优化
    // 使用时机，一个数增加会导致另一个数减少
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = nums[i];
            if (i == 0 || (left != nums[i - 1])) {
                int rightPoint = nums.length - 1;

                for (int j = i + 1; j < nums.length - 1; j++) {
                    int mid = nums[j];

                    if (j == i + 1 || (mid != nums[j - 1])) {
                        int right = nums[rightPoint];
                        //保证mid指针在right左
                        while (j < rightPoint && mid + left + nums[rightPoint] > 0) {
                            rightPoint--;
                            right=nums[rightPoint];
                        }
                        //第二第三指针相等，则没有符合条件的数据
                        if (j == rightPoint) {
                            break;
                        }
                        //ab确定后，只会有唯一一个c
                        if (left + mid + right == 0) {
                            result.add(Arrays.asList(left, mid, right));
                        }
                    }
                }
            }
        }
        return result;
    }

    //排序后,三重循环会超时
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {

                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || (nums[j] != nums[j - 1])) {

                        for (int k = j + 1; k < nums.length; k++) {
                            if (k == j + 1 || (nums[k] != nums[k - 1])) {
                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    //尝试使用set或map去重,是不行的
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new LinkedList<>();
//        LinkedList<HashSet<Integer>> duplicateList = new LinkedList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            int left = nums[i];
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                int mid = nums[j];
//                for (int k = j + 1; k < nums.length; k++) {
//                    int right = nums[k];
//                    if (left + mid + right == 0) {
//                        List<Integer> resultTemp = Arrays.asList(left, mid, right);
//                        if (duplicateList.size() == 0) {
//                            result.add(resultTemp);
//                            duplicateList.add(new HashSet<>(Arrays.asList(left, right, mid)));
//                        } else {
//                            boolean duplicate = false;
//                            for (HashSet<Integer> set : duplicateList) {
//                                if ((set.contains(left) && set.contains(mid)&&set.contains(right))) {
//                                    duplicate = true;
//                                    break;
//                                }
//                            }
//                            if (!duplicate) {
//
//                                result.add(resultTemp);
//                                duplicateList.add(new HashSet<>(Arrays.asList(left, right, mid)));
//                                break;
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }


}
