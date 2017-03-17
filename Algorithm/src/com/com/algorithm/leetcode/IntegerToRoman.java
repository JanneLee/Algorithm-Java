package com.algorithm.leetcode;

/**
 * change the integer number to roman number.
 * Created by lijianli on 2017/3/17.
 */
public class IntegerToRoman {

    public static void main(String[] args){
        System.out.println(solve(101));
    }

    public static String solve(Integer num){
        String[] dict = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder ret=new StringBuilder();
        for(int i=0; i<13; i++) {
            if(num>=val[i]) {
                int count = num/val[i];
                num %= val[i];
                for(int j=0; j<count; j++) {
                    ret.append(dict[i]);
                }
            }
        }
        return ret.toString();
    }

}
