package com.algorithm.leetcode;

/**
 * Created by lijianli on 2017/3/13.
 */
public class PalindromeNumber {

    public static void main(String[] args){
        System.out.println(isPalindromeNumber(101));
    }
    public static boolean isPalindromeNumber(Integer number){
        int temp=number,reverse=0;
        while(temp>0){
            reverse = reverse*10+temp%10;
            temp = temp/10;
        }
        if(number.intValue()==reverse){
            return true;
        }else{
            return false;
        }
    }
}
