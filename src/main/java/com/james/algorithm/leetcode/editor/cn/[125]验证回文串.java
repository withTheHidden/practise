////给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
////
//// 说明：本题中，我们将空字符串定义为有效的回文串。
////
////
////
//// 示例 1:
////
////
////输入: "A man, a plan, a canal: Panama"
////输出: true
////解释："amanaplanacanalpanama" 是回文串
////
////
//// 示例 2:
////
////
////输入: "race a car"
////输出: false
////解释："raceacar" 不是回文串
////
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 2 * 105
//// 字符串 s 由 ASCII 字符组成
////
//// Related Topics 双指针 字符串
//// 👍 448 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public  boolean isPalindrome(String s) {
//        char[] chars = s.toCharArray();
//        int k = s.length() - 1;
//        int i = 0;
//        while (i<k&&i<s.length()&&k>=0){
//            char aChar = chars[i];
//            char bChar = chars[k];
//            if (!Character.isLetterOrDigit(aChar)) {
//                i++;
//                continue;
//            }
//            if (!Character.isLetterOrDigit(bChar)){
//                k--;
//                continue;
//            }
//            if (Character.toLowerCase(aChar)!=Character.toLowerCase(bChar)) {
//                return false;
//            }
//            i++;
//            k--;
//        }
//        return true;
//    }
//
//}
////leetcode submit region end(Prohibit modification and deletion)
