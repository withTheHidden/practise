package com.james.algorithm.mycase.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 4, 9, 7,3};
        int[] result =shellSort(arr,arr.length/2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] shellSort(int[] arr,int gap) {
        if (null==arr||arr.length==0){
            return arr;
        }
        for (;gap>0;gap=gap/2){
            //分组
            for (int i = gap; i <arr.length; i++) {
                //每一组的下标可以算出来
                int j = i;
                //插入排序 
                while (j-gap>=0&&arr[j]<arr[j-gap])
                {
                    swap(arr,j,j-gap);
                    j=j-gap;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr,int a, int b) {
        if(a == b){
            return;
        }
        arr[a]=arr[a]^arr[b];
        arr[b]=arr[a]^arr[b];
        arr[a]=arr[a]^arr[b];
    }


}



