package com.james.algorithm.mycase;

//快速幂
public class FastPow {

    public static void main(String[] args) {
        int pow = pow(2, 10);
        System.out.println(pow);
    }
    public static int pow(int num, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return  pow(num,n/2)*pow(num,n/2)*num;
        }
        if (n % 2 == 0) {
            return  pow(num,n/2)*pow(num,n/2);
        }
        return num;
    }
}

