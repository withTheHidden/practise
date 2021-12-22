////设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
////
////
//// push(x) —— 将元素 x 推入栈中。
//// pop() —— 删除栈顶的元素。
//// top() —— 获取栈顶元素。
//// getMin() —— 检索栈中的最小元素。
////
////
////
////
//// 示例:
////
//// 输入：
////["MinStack","push","push","push","getMin","pop","top","getMin"]
////[[],[-2],[0],[-3],[],[],[],[]]
////
////输出：
////[null,null,null,null,-3,null,0,-2]
////
////解释：
////MinStack minStack = new MinStack();
////minStack.push(-2);
////minStack.push(0);
////minStack.push(-3);
////minStack.getMin();   --> 返回 -3.
////minStack.pop();
////minStack.top();      --> 返回 0.
////minStack.getMin();   --> 返回 -2.
////
////
////
////
//// 提示：
////
////
//// pop、top 和 getMin 操作总是在 非空栈 上调用。
////
//// Related Topics 栈 设计
//// 👍 1120 👎 0
//
//
//import java.util.LinkedList;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class MinStack {
//
//    LinkedList<Integer> list;
//    Integer min = null;
//
//    public MinStack() {
//        list = new LinkedList<>();
//    }
//
//    public void push(int val) {
//
//        list.add(val);
//        if (null == min || getMin() > val) {
//            min = val;
//        }
//    }
//
//    public void pop() {
//        Integer remove = list.removeLast();
//        if (remove.equals(min)){
//
//            if (list.size()!=0){
//                min=list.get(0);
//            }else {
//                min=null;
//                return;
//            }
//            for (Integer integer : list) {
//
//                if (min > integer) {
//                    min = integer;
//                }
//            }
//        }
//    }
//
//    public int top() {
//        return list.get(list.size()-1);
//    }
//
//    public int getMin() {
//        return min;
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
////leetcode submit region end(Prohibit modification and deletion)
//"MinStack","push",      "push",      "push",    "top","pop","getMin","pop","getMin","pop","push",      "top","getMin","push",      "top","getMin","pop","getMin"]
//[[],       [2147483646],[2147483646],[2147483647],[],  [],   [],      [],     [],    [],   [2147483647],[],   [],      [-2147483648],[],[],[],[]]