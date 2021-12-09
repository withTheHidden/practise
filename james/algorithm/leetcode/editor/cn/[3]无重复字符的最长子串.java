////给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
////
////
////
//// 示例 1:
////
////
////输入: s = "abcabcbb"
////输出: 3
////解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
////
////
//// 示例 2:
////
////
////输入: s = "bbbbb"
////输出: 1
////解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
////
////
//// 示例 3:
////
////
////输入: s = "pwwkew"
////输出: 3
////解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
////     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
////
////
//// 示例 4:
////
////
////输入: s = ""
////输出: 0
////
////
////
////
//// 提示：
////
////
//// 0 <= s.length <= 5 * 104
//// s 由英文字母、数字、符号和空格组成
////
//// Related Topics 哈希表 字符串 滑动窗口
//// 👍 6534 👎 0
//
//
//import java.util.HashSet;
//import java.util.Set;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
////    public int lengthOfLongestSubstring(String s) {
////        if (null==s||s.isEmpty()){
////            return 0;
////        }
////        if (s.length()==1){
////            return 1;
////        }
////        char[] chars = s.toCharArray();
////        HashSet<Character> set = new HashSet<>();
////        int k = 0;
////        int max = 0;
////        for (int i = 0; i < chars.length; i++) {
////            k=i;
////            while (k<chars.length){
////                if (!set.contains(chars[k])){
////                    set.add(chars[k]);
////                    k++;
////                }else {
////                    max = Math.max(set.size(), max);
////                    set.clear();
////                    break ;
////                }
////            }
////        }
////        return Math.max(set.size(), max);
////    }
//    //滑动窗口
////public static int  lengthOfLongestSubstring(String str){
////    Set<Character> set = new HashSet<>();
////
////    int k = 0;
////    int max = 0;
////    for (int i = 0; i < str.length(); i++) {
////        if (i!=0){
////            set.remove(str.charAt(i - 1));
////        }
////        while (k<str.length()&&!set.contains(str.charAt(k))){
////            set.add(str.charAt(k));
////            k++;
////        }
////        max = Math.max(max,set.size());
////    }
////    return max;
////}
//
////再优化
//public static int  lengthOfLongestSubstring(String str){
//    Set<Character> set = new HashSet<>();
//    int left = 0;
//    int right = 0;
//    int tmp = 0;
//    int result = 0;
//    while (right<str.length()){
//        if (set.add(str.charAt(right))){
//            right++;
//            tmp= right-left;
//        }else {
//            set.remove(str.charAt(left));
//            left++;
//        }
//        result = Math.max(tmp,result);
//    }
//    return result;
//}
//}
////leetcode submit region end(Prohibit modification and deletion)
