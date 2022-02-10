package com.james.algorithm.mycase;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] ints = {-2, 1, 3, 4,-1};
        List<Integer[]> result = find(ints,1);
        System.out.println(result);
    }

    private static List<Integer[]> find(int[] ints,int tar) {
        LinkedList<Integer[]> list = new LinkedList<>();
        if (ints.length<4){
            return list;
        }
        Arrays.sort(ints);
        int length = ints.length;
        int end = length-1;
        for (int i = 0; i < length-3; i++) {
            int endNum = ints[end];
            int tmp = tar - ints[i] - endNum;

            a:while (end>i){
            int innerStart = i+1;
            int innerEnd = end-1;
            for (int j = 0; j < innerStart-1; j++) {
                int k = innerEnd;
                int innerEndNum = ints[k];
                int innerTmp = tmp - ints[innerStart] - innerEndNum;
                while (innerTmp<0&&k>j){
                     k--;
                     innerTmp = tar- ints[k] -ints[j];
                }

                if (innerTmp==0){
                    Integer[] integers = {ints[i], ints[j], ints[k], ints[end]};
                    list.add(integers);
                    end--;
                    continue  a;
                }
            }
            end--;
            }


            }
        return list;
    }
}
