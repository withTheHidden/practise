package com.james.algorithm.mycase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeNumber {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum4(null);
        System.out.println(lists);
    }

    //更清晰的逻辑
    private static List<List<Integer>> threeSum4(int[] arr) {
        List<List<Integer>> result = new LinkedList<>();
        if (null==arr||arr.length<3){
            return result;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //第一个数字去重
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int targer = -arr[i];
            int L = i + 1;
            int R = arr.length - 1;
            while (L < R) {
                if (targer == arr[L] + arr[R]) {
                    result.add(Arrays.asList(-targer, arr[L], arr[R]));
                    //去重，注意，L++后，L位于与arr[L]数字相同的,下标最大的数字上
                    while (arr[L] == arr[L + 1]) {
                        L++;
                    }
                    //去重，注意，R--后，R位于与arr[R]数字相同的,下标最小的数字上,依旧是重复数字
                    while (arr[R] == arr[R - 1]) {
                        R--;
                    }
                    //相当于for循环++
                    L++;
                    //右指针也需要移动一次到新值上
                    R--;
                } else if (arr[i] + arr[L] + arr[R] > 0) {
                    R--;
                } else if (arr[i] + arr[L] + arr[R] < 0) {
                    L++;
                }

            }
        }
        return result;
    }


    //双指针优化
    // 使用时机，一个数增加会导致另一个数减少
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (null==nums||nums.length<3){
            return result;
        }
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
                            right = nums[rightPoint];
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
        if (null==nums||nums.length<3){
            return result;
        }
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
