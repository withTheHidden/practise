////给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
////ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
////
//// 说明：你不能倾斜容器。
////
////
////
//// 示例 1：
////
////
////
////
////输入：[1,8,6,2,5,4,8,3,7]
////输出：49
////解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
////
//// 示例 2：
////
////
////输入：height = [1,1]
////输出：1
////
////
//// 示例 3：
////
////
////输入：height = [4,3,2,1,4]
////输出：16
////
////
//// 示例 4：
////
////
////输入：height = [1,2,1]
////输出：2
////
////
////
////
//// 提示：
////
////
//// n == height.length
//// 2 <= n <= 105
//// 0 <= height[i] <= 104
////
//// Related Topics 贪心 数组 双指针
//// 👍 2979 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    //核心在于理解双指针,并理解移动指针导致面积的大小变化
//    public static int maxArea(int[] height) {
//        int left = 0;
//        int right =  (height.length - 1);
//        int initHigh = (height[left] <= height[right] ? height[left] : height[right]);
//        int area =  ((right - left) * initHigh);
//        int leftHigh = 0;
//        int rightHigh = 0;
//        while (left < right) {
//             leftHigh =  height[left];
//             rightHigh = height[right];
//            if (rightHigh >= leftHigh) {
//                left++;
//                area = areaCompare(area, left, right, height[left], rightHigh);
//            }
//            if (rightHigh < leftHigh) {
//                right--;
//                area = areaCompare(area, left, right, leftHigh, height[right]);
//            }
//        }
//        return area;
//    }
//    private static int areaCompare(int area, int left, int right, int leftHigh, int rightHigh) {
//        int i =  ((right - left) * (leftHigh <= rightHigh ? leftHigh : rightHigh));
//        return area>= i ? area :i;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
