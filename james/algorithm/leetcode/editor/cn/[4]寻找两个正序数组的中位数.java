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
//    //时间 m+n,空间 m+n
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int[] merger = new  int[length1 + length2];
//        int i = 0;
//        int k = 0;
//        int cur;
//        while (i< length1 ||k< length2){
//            if (i==length1){
//                cur = nums2[k];
//                k++;
//            }else if (k==length2){
//                cur = nums1[i];
//                i++;
//            }else if (nums1[i]<nums2[k]){
//                cur=nums1[i];
//                i++;
//            }else {
//                cur=nums2[k];
//                k++;
//            }
//            merger[i+k-1]=cur;
//        }
//        if(merger.length%2==0){
//            return (merger[(length1+length2)/2-1]+merger[(length1+length2)/2])/2.0;
//        }else {
//            return merger[(length1+length2)/2];
//        }
//    }
//    //逆向
//
//}
////leetcode submit region end(Prohibit modification and deletion)
