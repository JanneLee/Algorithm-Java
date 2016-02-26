/**
* @FileName PlusOne.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月26日下午10:45:53
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @ClassName PlusOne
 * @Description TODO
 * @Date 下午10:45:53
 */
public class PlusOne {

	/**
	 * @Title main
	 * @Description TODO
	 * @param args 
	 * @Return void
	 * @Throws 
	 * @user Administrator
	 * @Date 2016年1月26日
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,9};
		PlusOne p=new PlusOne();
		for(int i=0;i<p.plusOne(a).length;i++){
			System.out.println(p.plusOne(a)[i]);
		}
	}
	
	public int[] plusOne(int[] digits) {
		int flag=1;
		int re[]=null;
		Stack<Integer> s=new Stack<Integer>();
		for(int i=digits.length-1;i>=0;i--){
			int tmp=digits[i]+flag;
			flag=tmp/10;
			s.push(tmp%10);
		}
		if(flag==1){
			s.push(1);
		}
		re=new int[s.size()];
		int i=0;
		while(!s.isEmpty()){
			re[i++]=s.pop();
		}
        return re;
    }

}
