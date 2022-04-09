package com.james.algorithm.mycase.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 4, 6, 7};
        int[] ints = insertSort4(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);

        }
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        //从第一个数字开始便利，但并不是适合理解的方式
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int tmp = arr[j];
            for (; j > 0; j--) {
                if (arr[j - 1] > tmp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = tmp;
        }
        return arr;
    }

    //更符合思维的方法
    public static int[] insertSort2(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        //从第第一个要进行排序的数字开始，更符合思维
        for (int i = 1; i < arr.length; i++) {
            //与之比较的数字下标
            int j = i - 1;
            //存储临时值
            int tmp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    //更好的写法
    public static int[] insertSort3(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        //从第一个要进行排序的数字开始，更符合思维
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                int j = i - 1;
                int tmp = arr[i];
                for (; j >= 0 && arr[j] > tmp; j--) {
                    arr[j+1] = arr[j];
                }
                arr [j+1] = tmp;
            }
        }
        return arr;
    }

    //更简洁的写法
    public static int[] insertSort4(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        //从第一个要进行排序的数字开始，更符合思维
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            //如果tmp前面的数字大于tmp，则将该数字后移
            while (j>=0&&arr[j]>tmp){
                arr[j+1] = arr [j];
                j--;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    //选择排序
    public static int[] selectSort(int[] arr) {
        if (null == arr || 1 == arr.length) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int smallTmp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallTmp]) {
                    smallTmp = j;
                }
            }
            //选择出来才交换数字
            if (smallTmp!=i) {
                swap(arr, i, smallTmp);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
