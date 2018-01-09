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
        String s="))[]";
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
        String forwards="{[(";
        String backends="}])";
        stack.push(s.charAt(0));
        for(int i=1;i<len;i++){
            boolean push=true;
            for(int j=0;j<forwards.length();j++){
                if(Objects.equals(s.charAt(i),backends.charAt(j))){
                    push=false;
                    if(!Objects.equals(stack.pop(),forwards.charAt(j))){
                        return false;
                    }
                }
            }
            if(push){
                stack.push(s.charAt(i));
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
