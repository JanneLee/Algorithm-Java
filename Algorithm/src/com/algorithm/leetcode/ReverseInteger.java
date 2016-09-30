package com.algorithm.leetcode;

/**
 * Created by lijianli on 2016/9/29.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        Integer integer=new Integer(x);
        String inter=integer.toString();
        int len=integer.toString().length();
        String ret="";
        for(int i=0;i<len;i++){
            if(x<0){
                if(i>0) {
                    if (i == 1) {
                        ret += "-";
                    }
                    ret += inter.charAt(len - i);
                }
            }else {
                ret+=inter.charAt(len-i-1);
            }
        }
        return (new Long(ret).longValue()>Integer.MAX_VALUE||new Long(ret).longValue()<Integer.MIN_VALUE)?0:new Integer(ret).intValue();
    }

    public static int reverse2(int x){
        int ret=0;
        while (x!=0){
            int tmp=ret*10+x%10;
            x=x/10;
            if(tmp/10!=ret){
                ret=0;
                break;
            }
            ret=tmp;
        }
        return ret;
    }
    public static void main(String []args){
        System.out.println(new Integer(-321).toString());
        System.out.println(new Integer("-01").intValue());
        System.out.println(reverse(1534236469));
        System.out.println(reverse2(-321));
    }
}
