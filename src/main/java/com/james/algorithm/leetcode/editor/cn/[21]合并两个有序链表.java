////将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
////
////
////
//// 示例 1：
////
////
////输入：l1 = [1,2,4], l2 = [1,3,4]
////输出：[1,1,2,3,4,4]
////
////
//// 示例 2：
////
////
////输入：l1 = [], l2 = []
////输出：[]
////
////
//// 示例 3：
////
////
////输入：l1 = [], l2 = [0]
////输出：[0]
////
////
////
////
//// 提示：
////
////
//// 两个链表的节点数目范围是 [0, 50]
//// -100 <= Node.val <= 100
//// l1 和 l2 均按 非递减顺序 排列
////
//// Related Topics 递归 链表
//// 👍 2094 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//class Solution {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode first = list1;
//        ListNode second = list2;
//
//        ListNode result = new ListNode();
//        ListNode resultPoint = result;
//
//        while (first!=null&& second!=null){
//            if (first.val>=second.val){
//                resultPoint.next = second;
//                second =second.next;
//            } else {
//                resultPoint.next = first;
//                first=first.next;
//            }
//            resultPoint = resultPoint.next;
//
//        }
//
//        if (first==null){
//            resultPoint.next = second;
//        }else {
//            resultPoint.next = first;
//        }
//
//        return result.next;
//
//
//    }
//
//}
////leetcode submit region end(Prohibit modification and deletion)
