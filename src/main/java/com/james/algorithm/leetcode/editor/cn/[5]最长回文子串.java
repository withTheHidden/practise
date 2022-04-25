////给你一个字符串 s，找到 s 中最长的回文子串。
////
////
////
//// 示例 1：
////
////
////输入：s = "babad"
////输出："bab"
////解释："aba" 同样是符合题意的答案。
////
////
//// 示例 2：
////
////
////输入：s = "cbbd"
////输出："bb"
////
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 1000
//// s 仅由数字和英文字母组成
////
//// Related Topics 字符串 动态规划
//// 👍 5029 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    // arr[left][right]= true/false, 表示字符串s的下标left到right的这个字串是否是回文串
//    // arr[left][right] =  (s[left] == s[right])&& arr[left+1][right-1] ==true;
//    // 字符串s到l是回文由 left和right代表的字母相等 且  去掉left和right后,内部的字串是否还是回文
//    //边界:1.  left=right时单个字母是回文 2.两个字母的时候相等就是回文  3.长度限制 left+长度-1 < s.length
//    public static String longestPalindrome(String s) {
//        char[] chars = s.toCharArray();
//        //状态数组 , 行表示长度,因为长度从1开始,所以长度加一,列 从第几个数字开始
//        boolean[][] arr = new boolean[chars.length+1][chars.length];
//        //初始化数组,单个字母肯定为回文串.第一行不需要
//        for (int i = 0; i < chars.length; i++) {
//            arr[0][i] = true;
//            arr[1][i] = true;
//        }
//        int maxLength = 0;
//        int resultLeft = 0;
//        int resultRight = 0;
//        //遍历长度,长度1 已经在二维数组里了
//        for (int len = 2; len <= chars.length; len++) {
//            //遍历下标
//            for (int left = 0; left + len - 1 < chars.length; left++) {
//                //确定right下标
//                int right = left + len - 1;
//
//                //两个下标数字是否相等
//                if (!(chars[left] == chars[right])) {
//                    //left到right肯定不是回文串
//                    continue;
//                } else if (len <= 3) {
//                    arr[len][left] = true;
//                } else {
//                    // 长度减2: 左边加一,右边减一
//                    arr[len][left] = arr[len - 2][left + 1];
//                }
//
//                if (true == arr[len][left] && len > maxLength) {
//                    maxLength = len;
//                    resultLeft = left;
//                    resultRight = right;
//                }
//
//            }
//        }
//        //左闭右开
//        return s.substring(resultLeft, resultRight + 1);
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
