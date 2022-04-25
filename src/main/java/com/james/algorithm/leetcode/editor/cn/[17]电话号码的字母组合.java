////给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
////
//// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
////
////
////
////
////
//// 示例 1：
////
////
////输入：digits = "23"
////输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
////
////
//// 示例 2：
////
////
////输入：digits = ""
////输出：[]
////
////
//// 示例 3：
////
////
////输入：digits = "2"
////输出：["a","b","c"]
////
////
////
////
//// 提示：
////
////
//// 0 <= digits.length <= 4
//// digits[i] 是范围 ['2', '9'] 的一个数字。
////
//// Related Topics 哈希表 字符串 回溯
//// 👍 1634 👎 0
//
//
//import java.util.*;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//
//    //回溯法速度快
//     List<String> res = new LinkedList<>();
//     String[] letterMap = {" ","*", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};
//    public List<String> letterCombinations(String digits) {
//        if (null == digits || digits.length() == 0) {
//            return new ArrayList<>();
//        }
//        iterStr(digits, new StringBuilder(), 0);
//        return res;
//    }
//
//    private void iterStr(String digits, StringBuilder stringBuilder, int index) {
//        if (digits.length() == index) {
//            res.add(stringBuilder.toString());
//            return;
//        }
//        char c = digits.charAt(index);
//        int point = c - '0';
//        String map_string = letterMap[point];
//
//        for (int i = 0; i < map_string.length(); i++) {
//            stringBuilder.append(map_string.charAt(i));
//            iterStr(digits, stringBuilder, index + 1);
//            //去掉路径上面添加的字母
//            stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        }
//    }
//
////    static HashMap<String, String[]> map = new HashMap<String, String[]>() {{
////        put("1", new String[]{""});
////        put("2", new String[]{"a", "b", "c"});
////        put("3", new String[]{"d", "e", "f"});
////        put("4", new String[]{"g", "h", "i"});
////        put("5", new String[]{"j", "k", "l"});
////        put("6", new String[]{"m", "o", "n"});
////        put("7", new String[]{"p", "q", "r", "s"});
////        put("8", new String[]{"t", "u", "v"});
////        put("9", new String[]{"w", "x", "y", "z"});
////    }};
////
////
////
////    public  List<String> letterCombinations(String s) {
////        LinkedList<String> list = new LinkedList<>();
////        if (null == s || "1".equals(s)) {
////            list.add("");
////            return list;
////        }
////        if (s.length() == 1) {
////            return Arrays.asList(map.get(s));
////        }
////        char[] chars = s.toCharArray();
////
////        for (int i = 0; i < chars.length; i++) {
////            if ('1' == chars[i]) {
////                continue;
////            }
////            String[] strings = map.get(String.valueOf(chars[i]));
////
////            if (i == 0) {
////                Collections.addAll(list, strings);
////            } else {
////                LinkedList<String> listTmp = new LinkedList<>();
////                for (String now : list) {
////                    for (String toAdd : strings) {
////                        listTmp.add(now + toAdd);
////                    }
////                }
////                list = listTmp;
////            }
////
////        }
////        return list;
////    }
//
//}
////leetcode submit region end(Prohibit modification and deletion)
