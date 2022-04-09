////给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
////
//// 算法的时间复杂度应该为 O(log (m+n)) 。
////
////
////
//// 示例 1：
////
////
////输入：nums1 = [1,3], nums2 = [2]
////输出：2.00000
////解释：合并数组 = [1,2,3] ，中位数 2
////
////
//// 示例 2：
////
////
////输入：nums1 = [1,2], nums2 = [3,4]
////输出：2.50000
////解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
////
////
//// 示例 3：
////
////
////输入：nums1 = [0,0], nums2 = [0,0]
////输出：0.00000
////
////
//// 示例 4：
////
////
////输入：nums1 = [], nums2 = [1]
////输出：1.00000
////
////
//// 示例 5：
////
////
////输入：nums1 = [2], nums2 = []
////输出：2.00000
////
////
////
////
//// 提示：
////
////
//// nums1.length == m
//// nums2.length == n
//// 0 <= m <= 1000
//// 0 <= n <= 1000
//// 1 <= m + n <= 2000
//// -106 <= nums1[i], nums2[i] <= 106
////
//// Related Topics 数组 二分查找 分治
//// 👍 4726 👎 0
//
//
//import java.util.Arrays;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    //因为是两个有序数组,直接 归并合并
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        //用来保存合并后数据
//        int[] result = new int[nums1.length+nums2.length];
//        int i = 0;
//        int j = 0;
//        int index = 0;
//        while (i<nums1.length && j<nums2.length){
//            //nums的数据小于nums2,则放入result数组
//            if (nums1[i]<nums2[j]){
//                result[index] = nums1[i];
//                index++;
//                i++;
//            }else {
//                result[index] = nums2[j];
//                index++;
//                j++;
//            }
//        }
//
//        //有一个数组已经完成遍历:nums1,遍nums2的数字加入result数组
//        if (i>=nums1.length)
//        {
//            while (index<result.length){
//                result[index++] = nums2[j++];
//            }
//        }else {
//            while (index<result.length){
//                result[index++] = nums1[i++];
//            }
//        }
//
//        //找到中位数,偶数even,奇数odd
//        boolean odd = (result.length%2==1);
//        //注意,此处的index = result.length
//        int mid = index / 2;
//        // 注意返回的是double 要除以2.0才对.
//        // 注意 index = result.length,所以 mid -1
//        return odd?(result[mid]):(result[mid-1]+result[mid])/2.0;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
