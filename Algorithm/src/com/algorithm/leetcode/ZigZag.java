/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 */

package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lijianli on 2016/9/29.
 */
public class ZigZag {
    public static String convert(String s, int numRows) {
        if(s==null||s.length()==0){
            return "";
        }
        int len=s.length();
        if(len<numRows||numRows==1){
            return s;
        }
        StringBuilder ret=new StringBuilder();
        int internal=(numRows<<1)-2;
//        for(int i=0;i<len;i+=internal){
//            ret.append(s.charAt(i));
//        }
        for(int j=0;j<numRows;j++){
            for(int i=j;i<len;i+=internal){
                ret.append(s.charAt(i));
                if(j!=0&&j!=numRows-1){
                    int inter=i+internal-(j<<1);
                    if(inter<len)
                        ret.append(s.charAt(inter));
                }
            }
        }
//        for(int i=numRows-1;i<len;i+=internal){
//            ret.append(s.charAt(i));
//        }
        return ret.toString();
    }


    public static String covert2(String s,int numRows){
        if(s==null||s.length()==0){
            return "";
        }
        int len=s.length();
        if(len<numRows||numRows==1){
            return s;
        }
        String[] ss = new String[numRows];    // 用来存储每一行
        Arrays.fill(ss, "");
        int nGroup = 2 * (numRows-1);     // 每nGroup，zigzag pattern就会重复一遍

        for(int i=0; i<s.length(); i++){
            /*
             eg: numRows=4, nGroup=6
             i%group:                   0,1,2,3,4,5
             numRows-1-(i%nGroup):        3,2,1,0,-1,-2
             abs():                     3,2,1,0,1,2
             total:                     0,1,2,3,2,1
             */
            ss[numRows-1-Math.abs(numRows-1-(i%nGroup))] += s.charAt(i);
        }
        StringBuilder sb=new StringBuilder();
        for(String str : ss){
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(8<<2);//8*2^2
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(covert2("PAYPALISHIRING",3));
    }
}
