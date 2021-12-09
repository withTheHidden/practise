////给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
////
//// 返回这三个数的和。
////
//// 假定每组输入只存在恰好一个解。
////
////
////
//// 示例 1：
////
////
////输入：nums = [-1,2,1,-4], target = 1
////输出：2
////解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
////
////
//// 示例 2：
////
////
////输入：nums = [0,0,0], target = 1
////输出：0
////
////
////
////
//// 提示：
////
////
//// 3 <= nums.length <= 1000
//// -1000 <= nums[i] <= 1000
//// -104 <= target <= 104
////
//// Related Topics 数组 双指针 排序
//// 👍 960 👎 0
//
//
//import org.omg.PortableInterceptor.INACTIVE;
//
//import java.util.*;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    //再次优化
//    public static int threeSumClosest(int[] nums, int target) {
//        List<Integer> list = new ArrayList<>(5);
//        Arrays.sort(nums);
//        int ans = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length; i++) {
//            int M = i + 1;
//            int R = nums.length - 1;
//            while (M < R) {
//                int sum = nums[i] + nums[M] + nums[R];
//                if (Math.abs(target - sum) < Math.abs(target - ans)) {
//                    ans = sum;
//                }
//                if (sum > target) {
//                    R--;
//                } else if (sum < target) {
//                    M++;
//                } else {
//                    //sum = target
//                    return ans;
//                }
//            }
//        }
//        System.out.println(list);
//        return ans;
//    }
//
//    //优化
////    public static int threeSumClosest(int[] nums, int target) {
////    int result = 0;
////    List<Integer> list = new ArrayList<>(5);
////        Arrays.sort(nums);
////    result = nums[0] + nums[1] + nums[nums.length - 1];
////
////        for (int i = 0; i < nums.length; i++) {
////        int left = nums[i];
////
////        int M = i + 1;
////        int R = nums.length - 1;
////        while (M < R) {
////            int mid = nums[M];
////            int right = nums[R];
////            int sum = left + mid + right;
////            if (Math.abs(sum - target) < Math.abs(result - target)) {
////                result = sum;
////                list = Arrays.asList(nums[i], nums[M], nums[R]);
////            }else if (sum - target > 0) {
////                R--;
////            }else if (sum - target < 0) {
////                M++;
////            }else if (sum == target) {
////                list = Arrays.asList(nums[i], nums[M], nums[R]);
////                return result;
////            }
////
////        }
////    }
////        System.out.println(list);
////        return result;
////}
////    public static int threeSumClosest1(int[] nums, int target) {
////        int result = 0;
////        int abs = -1;
////        List<Integer> list = new ArrayList<>(5);
////        Arrays.sort(nums);
////        result = nums[0] + nums[1] + nums[nums.length - 1];
////        abs = Math.abs(result - target);
////
////        for (int i = 0; i < nums.length; i++) {
////            int left = nums[i];
////
////           int M = i + 1;
////           int R = nums.length - 1;
////            while (M < R) {
////                int mid = nums[M];
////                int right = nums[R];
////                int sum = left + mid + right;
////                int tmp = sum - target;
////                if (Math.abs(tmp) <= Math.abs(abs)) {
////                    result = sum;
////                    abs = Math.abs(tmp);
////                    list = Arrays.asList(nums[i], nums[M], nums[R]);
////                    if (tmp == 0) {
////                        return result;
////                    }
////                }
////
////                if (tmp > 0) {
////                    R--;
////                }
////                if (tmp < 0) {
////                    M++;
////                }
////
////            }
////        }
////        System.out.println(list);
////        return result;
////    }
//}
////leetcode submit region end(Prohibit modification and deletion)
