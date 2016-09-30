package com.algorithm.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lijianli on 2016/9/29.
 */
public class Atoi {
    public static int myAtoi(String str) {
        if(null==str||str.length()==0){
            return 0;
        }
        Pattern pattern1=Pattern.compile("(.*)(\\+|\\-)( ){1,}\\d+(.*)");
        if(pattern1.matcher(str).matches()){
            return 0;
        }
        str=str.trim();
        if(str.length()>18){
            return 0;
        }
        Pattern pattern=Pattern.compile("(\\+|\\-){2,}(.*)");
        if(pattern.matcher(str).matches()){
            return 0;
        }
        Pattern pattern2=Pattern.compile("(\\+|\\-|){1}\\D+\\d+");
        if(pattern2.matcher(str).matches()){
            return 0;
        }
        Pattern p=Pattern.compile("(\\+|\\-|){1}\\d+");
        Matcher matcher=p.matcher(str);
        if(matcher.find()){
            str=matcher.group(0);
        }else{
            return 0;
        }
        System.out.println(str);
        if(new Long(str).longValue()>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(new Long(str).longValue()<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return new Integer(str).intValue();
        }
    }

    public static void main(String []args){
        Pattern p=Pattern.compile("(\\+|\\-|){1}\\d+");
        Matcher m1=p.matcher("+-1");
        System.out.println(m1.matches());
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("+1d22"));
        System.out.println(myAtoi("+dd"));
        System.out.println(myAtoi("+1222"));

//        Pattern pattern = Pattern.compile("(\\+|\\-|)\\d+");
//        Matcher matcher = pattern.matcher("-12d");
//        while (matcher.find()) {
//            System.out.println(matcher.group(0));
//        }
//
//        Pattern pattern1=Pattern.compile("(\\+|\\-){2,}(.*)");
//        System.out.println(pattern1.matcher("-+1").matches());
//
//        Pattern pattern2=Pattern.compile("(.*)( ){1,}\\d+(.*)");
//        System.out.println(pattern2.matcher("+ 321").matches());

    }
    public static int sta(String str){
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}
