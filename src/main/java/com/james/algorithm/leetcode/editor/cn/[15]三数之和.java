//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 4038 👎 0


import org.springframework.util.CollectionUtils;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //核心在去重,hash表可以暂存数据,但去重很困难
    //相同的数字元组 , 不同的顺序会重复, 可以用对数字排序来限定唯一的数字元组
    //如 (abc cba bca) 限定数字顺序为从小到大排列,可以唯一确定一个abc三个数字组成的元组
    //需要先排序
    //而双指针使用时机，一个数增加会导致另一个数减少
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new LinkedList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i == 0 || (nums[i] != nums[i - 1])) {
//
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    if (j == i + 1 || (nums[j] != nums[j - 1])) {
//
//                        for (int k = j + 1; k < nums.length; k++) {
//                            if (k == j + 1 || (nums[k] != nums[k - 1])) {
//                                if (nums[i] + nums[j] + nums[k] == 0) {
//                                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
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
}
//leetcode submit region end(Prohibit modification and deletion)
