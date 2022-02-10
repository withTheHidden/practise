package com.james.algorithm.mycase.find;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 5};
        int index = binarySearchDuplicateFirstBigger(arr, -1);
        System.out.println(index);
    }

    //没有重复数据时查找
    private static int binarySearchNoduplicate(int[] arr, int find) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == find) {
                return mid;
            }
            if (arr[mid] > find) {
                right = mid - 1;
            } else if (arr[mid] < find) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //有重复数据,查找到第一个与 find 值相同的
    private static int binarySearchDuplicate(int[] arr, int find) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > find) {
                right = mid - 1;
            } else if (arr[mid] < find) {
                left = mid + 1;
            } else {
                //当且仅当mid是最后一个数字的时候 返回mid
                if (mid == 0 || arr[mid - 1] != find) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //有重复数据,查找到  最后一个  与 find 值相同的
    private static int binarySearchDuplicateFindLast(int[] arr, int find) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > find) {
                right = mid - 1;
            } else if (arr[mid] < find) {
                left = mid + 1;
            } else {
                //当且mid是最后一个数字的时 或者 当mid的下一个数字不是find时 ,说明该数字已经是最后一个等于find的数字了
                if (mid == arr.length - 1 || arr[mid + 1] != find) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    //有重复数据,查找 第一个大于给定元素 的值
    //注意 该条件的边界条件 大于给定元素 则这个值可以不存在于该数组内.
    private static int binarySearchDuplicateFirstBigger(int[] arr, int find) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= find) {
               if (mid==0||arr[mid-1]<find){
                   return mid;
               }else {
                   right = mid -1;
               }
            } else if (arr[mid] < find) {
                left = mid + 1;
            }
        }
        return -1;
    }
}