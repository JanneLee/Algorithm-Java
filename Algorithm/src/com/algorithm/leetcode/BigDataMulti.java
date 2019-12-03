package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author lijianli
 * @date 2019/6/10
 */
public class BigDataMulti {
    public static void main(String[] args) {
        String a = "98999";
        String b = "21";

        char[] charArr1 = a.trim().toCharArray();
        char[] charArr2 = b.trim().toCharArray();

        int[] arr1 = new int[charArr1.length];
        int[] arr2 = new int[charArr2.length];
        for(int i = 0; i < charArr1.length; i++){
            arr1[i] = charArr1[i] - '0';
        }
        for(int i = 0; i < charArr2.length; i++){
            arr2[i] = charArr2[i] - '0';
        }
        System.out.println(Arrays.toString(bigNumMulti(arr1, arr2)));

        System.out.println("aaa-aaa-".split("-").length);
    }
    public static  Integer [] bigNumMulti(int []arr1,int [] arr2){
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=arr2.length-1;i>=0;i--){
            int carry=0;
            ArrayList<Integer> singleList=new ArrayList<>();

            for(int j=arr1.length-1;j>=0;j--){
                int r=arr2[i] * arr1[j]+carry;
                int digit=r%10;
                carry=r/10;
                singleList.add(digit);
            }

            if(carry!=0){
                singleList.add(carry);
            }

            int resultCarry=0,count=0;
            int k=0,l=0;
            int offset=arr2.length-1-i;

            ArrayList<Integer> middleList=new ArrayList<>();

            while(k<singleList.size()|| l<result.size()){
                int kv=0,lv=0;
                if(k<singleList.size() && count>=offset){
                    kv=singleList.get(k++);
                }
                if(l<result.size()){
                    lv=result.get(l++);
                }
                int sum=resultCarry+kv+lv;
                middleList.add(sum%10);
                resultCarry=sum/10;
                count++;
            }

            result.clear();
            result=middleList;

        }
        Collections.reverse(result);
        return result.toArray(new Integer[result.size()]);
    }
}
