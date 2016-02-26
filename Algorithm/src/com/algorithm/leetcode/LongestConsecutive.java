/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @FileName LongestConsecutive.java
 * @Package com.algorithm.leetcode
 * @Description TODO[what the file to do]
 * @Author ali blog:http://www.cnblogs.com/accipiter
 * @Date 2016年2月23日下午2:33:47
 * @Version V1.0.1
 * @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
 */
package com.algorithm.leetcode;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LongestConsecutive
 * @Description TODO
 * @Date 下午2:33:47
 */
public class LongestConsecutive {

	/**
	 * @Title main
	 * @Description TODO
	 * @Return void
	 * @Throws 
	 * @user Administrator
	 * @Date 2016年2月23日
	 */
	public static void main(String[] args) {
//		int a[]={1,2,4,6,3};
//		System.out.println(longestConsecutive2(a));
		System.out.println(fib(9));
	}
	/**
	* @Title longestConsecutive
	* @Description how to think it is the best one.
	* @Return int
	* @Throws 
	* @user Administrator
	* @Date 2016年2月23日
	 */
	public static int longestConsecutive(int[] num){
		if(num.length==0){
			return 0;
		}
		Set<Integer> set=new HashSet<Integer>();
		int max=1;
		for(int e:num){
			set.add(e);
		}
		for(int e:num){
			int left=e-1;
			int right=e+1;
			int count=1;
			while(set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			max=Math.max(count, max);
		}
		return max;
	}
	public static int fib(int n){
		if(n<1)return 1;
		else{
			return fib(n-1)+fib(n-2);
		}
	}
}
