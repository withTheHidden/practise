package com.james.algorithm.mycase.sort;

public class AdvancedSort {
    public static void main(String[] args) {
        int[] arr = new int[]{31, 24, 45, 67, 54, 87, 98, 12, 15, 89};
        fastSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

    //希尔排序 ，分组排序后聚合
    public static int[] shellSort(int[] arr) {
        //分组
        int gap = arr.length / 2;
        for (; gap > 0; gap = gap / 2) {
            //被用来比较的数字 arr[gap], 第一个进行比较的是 gap和 gap-i
            for (int i = gap; i < arr.length; i = i + gap) {
                int tmp = arr[i];
                int k = i - gap;
                while (k >= 0 && arr[k] > tmp) {
                    arr[k + gap] = arr[k];
                    k = k - gap;
                }
                arr[k + gap] = tmp;
            }
        }
        return arr;
    }

    //希尔排序 ，内部使用冒泡，性能较差,容易写错
    public static int[] shellSort2(int[] arr) {
        int sum = 0;
        //分组
        int gap = arr.length / 2;
        for (; gap > 0; gap = gap / 2) {
            for (int i = 0; i < gap; i++) {

                for (int j = i; j < arr.length - gap; j = j + gap) {
                    for (int k = j + gap; k < arr.length; k = k + gap) {
                        if (arr[j] > arr[k]) {
                            swap(arr, j, k);
                        }
                    }

                }


            }
        }
        return arr;
    }

    //归并
    public static int[] mergeSort(int[] arr) {
        mergeSort_in(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort_in(int[] arr, int l, int r) {
        //归并的递归到最后,至少有两个数字比较,如果只剩一个数字(l>=r),则没有比较的价值因此返回
        if (l >= r) {
            return;
        }
        int p = (l + r) >> 1;
        mergeSort_in(arr, l, p);
        mergeSort_in(arr, p + 1, r);
        merge(arr, l, r, p);
    }

    private static int[] merge(int[] arr, int l, int r, int p) {
        int[] tmp = new int[r - l + 1];
        int left = l;
        //point = p+1  因为被分割的两个部分为 [l...p] 和 [p+1...r]
        int point = p + 1;
        int indexToInsert = 0;

        while (left <= p && point <= r) {
            if (arr[left] > arr[point]) {
                tmp[indexToInsert] = arr[point];
                point++;
            } else {
                tmp[indexToInsert] = arr[left];
                left++;
            }
            indexToInsert++;
        }

        int start = left;
        int end = p;
        if (left > p) {
            start = point;
            end = r;
        }

        while (start <= end) {
            tmp[indexToInsert++] = arr[start++];
        }

//        if (left > p) {
//            while (point <= r) {
//                tmp[indexToInsert] = arr[point];
//                indexToInsert++;
//                point++;
//            }
//        } else {
//            while (left <= p) {
//                tmp[indexToInsert] = arr[left];
//                indexToInsert++;
//                left++;
//            }
//        }

        while (r >= l) {
            arr[r] = tmp[r - l];
            r--;
        }
        return arr;
    }

    //快排
    public static int[] fastSort(int[] arr) {
        fastSort_space(arr, 0, arr.length - 1);
        return arr;
    }

    private static void fastSort_normal(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = fastSort_normal_sort(arr, l, r);
        fastSort_normal(arr, l, q - 1);
        fastSort_normal(arr, q + 1, r);
    }

    //空间换代码复杂度
    private static int fastSort_normal_sort(int[] arr, int l, int r) {
        int target = arr[r];
        int pivot = r;
        int[] tmpArrOne = new int[arr.length];
        int tmpArrOneIndex = 0;
        int[] tmpArrTwo = new int[arr.length];
        int tmpArrTwoIndex = 0;

        //大于等于target 和小于 target 的数字分别放入两个数组中
        for (int i = l; i <= r; i++) {
            if (arr[i] <= target) {
                tmpArrOne[tmpArrOneIndex++] = arr[i];
            } else {
                tmpArrTwo[tmpArrTwoIndex++] = arr[i];
            }
        }

        //得出 分界点 的下标
        if (tmpArrOneIndex > 0) {
            pivot = l - 1 + tmpArrOneIndex;
        } else {
            pivot = l - 1 + tmpArrTwoIndex;
        }

        //将两个数组中的数据放入到原数组中
        int index = l;
        if (tmpArrOneIndex > 0) {
            for (int i = 0; i < tmpArrOneIndex; i++) {
                arr[index++] = tmpArrOne[i];
            }
        }
        if (tmpArrTwoIndex > 0) {
            for (int i = 0; i < tmpArrTwoIndex; i++) {
                arr[index++] = tmpArrTwo[i];
            }
        }

        return pivot;
    }

    //空间复杂度为O(1) ,类似于插入排序
    private static void fastSort_space(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = fastSort_space_sort(arr, l, r);
        fastSort_space(arr, l, q - 1);
        fastSort_space(arr, q + 1, r);
    }

    private static int fastSort_space_sort(int[] arr, int l, int r) {
        int target = arr[r];
        //i 遍历数组的下标
        int i = l;
        //j 用来区分 大于 target 和小于 target 的中间点
        int j = l;
        for (; i < r; i++) {
            if (arr[i] < target) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, r);
        return j;
    }


    private static void swap(int[] arr, int a, int b) {
        int i = arr[a];
        int j = arr[b];
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        arr[a] = i;
        arr[b] = j;
    }
}
