//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
// Related Topics 递归 数学
// 👍 820 👎 0


import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        long c = n;
        return c>=0?pow(x, c):1/pow(x,-c);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double pow = pow(x, n / 2);
        if (n % 2 == 0) {
            return  pow * pow;
        } else {
            return  pow * pow *x;
        }
    }

    public double myPow2(double num,int n){
        return n>=0?newPow(num,n):1/newPow(num,-n);
    }

    private double newPow(double num, int n) {
        if (n==0){
            return 1.0;
        }
        double result = newPow(num,n/2);
        if (n%2==0){
            return result*result;
        }else {
            return result*result*num;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
