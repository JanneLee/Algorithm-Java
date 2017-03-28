/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 编写一个函数来查找字符串数组中最长的公共前缀字符串。
 */

package com.algorithm.leetcode;

/**
 * Created by lijianli on 2017/3/17.
 */
public class FindLargestPrefix {
    public static void main(String[] args){
        String[] strs={"aac","ac"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int minLength=strs.length+1;
        for(String str:strs){
            if(minLength>str.length()){
                minLength=str.length();
            }
        }
        for(int i=0;i<minLength;i++){
            for(int j=0;j<strs.length-1;j++){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i)){
                    return strs[j].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,minLength);
    }
}
