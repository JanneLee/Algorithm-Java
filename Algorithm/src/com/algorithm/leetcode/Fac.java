package com.algorithm.leetcode;

/**
 *
 * @author lijianli
 * @date 2018/4/6
 */
public class Fac {
    public static void main(String[] args) {
        System.out.println(f(10));
        System.out.println(f1(10));

    }

    private static long f(int n){
        if(n == 1) {
            return 1;
        }else if(n == 2){
            return 2;
        }
        return f(n-1)+f(n-2);
    }

    private static long f1(int n){
        int a=1,b=2,c=1;
        if(n == 1) {
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            for(int i = 3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
        }
        return c;
    }
}
