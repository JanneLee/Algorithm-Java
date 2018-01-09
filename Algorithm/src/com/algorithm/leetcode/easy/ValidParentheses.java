package com.algorithm.leetcode.easy;

import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author lijianli
 * @date 2018/1/9
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s="{}(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        if(null==s || s.length()==0){
            return false;
        }
        int len=s.length();
        int d=2;
        if(len%d != 0){
            return false;
        }
        Stack stack=new Stack();
        String characters="([{}])";
        for(int i=0;i<len;i+=d){
            stack.push(s.charAt(i));
        }
        for(int i=len-1;i>0;i-=d){
            System.out.println(s.charAt(i));
            for(int j=0;j<characters.length();j++){
                if(Objects.equals(s.charAt(i),characters.charAt(j))){
                    System.out.println(j+":"+Math.abs(characters.length()-j-1));
                    System.out.println(characters.charAt(j));
                    System.out.println(characters.charAt(Math.abs(characters.length()-j-1)));
                    char c= (char) stack.pop();
                    System.out.println("char:"+c);
                    if(!Objects.equals(c,characters.charAt(Math.abs(characters.length()-j-1)))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
