package com.algorithm.other;

/**
 *
 * @author lijianli
 * @date 2018/7/4
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }

    private static double sqrt(double n){
        double k=1D;
        while (Math.abs(k*k-n)>1e-9){
            k=((k+n/k)/2);
        }
        return k;
    }
}
