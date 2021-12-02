package com.james.algorithm.recite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReciteThree {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(null);
        System.out.println(lists);
    }

    //初步去重
    public static List<List<Integer>> threeSum(int[] nums) {
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

    //更清晰的逻辑
    private static List<List<Integer>> threeSum2(int[] arr) {
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
            for (; L < R; L++) {
                if(targer==arr[L]+arr[R]){
                    result.add(Arrays.asList(-targer,arr[L],arr[R]));
                }
                while (arr[L]==arr[L+1]){L++;}
                while (arr[R]==arr[R-1]){R--;}
            }
        }
        return result;
    }
}
