////给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
////
//// 有效字符串需满足：
////
////
//// 左括号必须用相同类型的右括号闭合。
//// 左括号必须以正确的顺序闭合。
////
////
////
////
//// 示例 1：
////
////
////输入：s = "()"
////输出：true
////
////
//// 示例 2：
////
////
////输入：s = "()[]{}"
////输出：true
////
////
//// 示例 3：
////
////
////输入：s = "(]"
////输出：false
////
////
//// 示例 4：
////
////
////输入：s = "([)]"
////输出：false
////
////
//// 示例 5：
////
////
////输入：s = "{[]}"
////输出：true
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 104
//// s 仅由括号 '()[]{}' 组成
////
//// Related Topics 栈 字符串
//// 👍 2841 👎 0
//
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean isValid(String s) {
//         Map<Character,Character> map = new HashMap<Character,Character>(){{
//            put('{','}');
//            put('(',')');
//            put('[',']');
//        }};
//
//        LinkedList<Character> list = new LinkedList<>();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if (map.containsKey(c)){
//                list.addFirst(c);
//            }else {
//                if (list.size()==0){
//                    return false;
//                }
//                Character toCheck = map.get(list.removeFirst());
//                if (c!=toCheck){
//                    return false;
//                }
//            }
//        }
//        //注意要清空数组
//        return list.size() == 0;
//    }
//
//
//}
////leetcode submit region end(Prohibit modification and deletion)
