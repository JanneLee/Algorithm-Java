/**
* @FileName TwoSum.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月25日上午1:37:57
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Date 上午1:37:57
 */
public class TwoSum {
	
	public int[] twoSum(int []nums,int target){
		if(nums==null||nums.length==0){
			return null;
		}
		int re[]=new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					re[0]=i+1;
					re[1]=j+1;
				}
			}
		}
		return re;
	}

	/**
	 * @Title main
	 * @Description TODO
	 * @param args 
	 * @Return void
	 * @Throws 
	 * @user Administrator
	 * @Date 2016年1月25日
	 */
	public static void main(String[] args) {
		int nums[]={1,2,4,5,7,9};
		int target=11;
		TwoSum ts=new TwoSum();
		System.out.println(ts.twoSum(nums, target)[0]+" "+ts.twoSum(nums, target)[1]);
	}
}
