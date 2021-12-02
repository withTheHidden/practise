package com.james.algorithm.recite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReciteThree {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    private static List<List<Integer>>  threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new LinkedList<>();
        for (int first = 0; first < arr.length - 2; first++) {
            int left = arr[first];
            int third = arr.length-1;

            if (first == 0 || left != arr[first-1]) {
                for (int second = first + 1; second < arr.length - 1; second++) {
                    int mid = arr[second];
                    if (second == first+1 || mid!= arr[second-1]){
                        while (second<third && left+mid+arr[third]>0){
                            third--;
                        }
                        if (second == third){
                            break;
                        }
                        if (left+mid+arr[third] == 0){
                            result.add(Arrays.asList(left,mid,arr[third]));
                        }
                    }
                }

            }
        }
        return result;

    }
}
