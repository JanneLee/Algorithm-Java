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
 * @FileName RemoveDup.java
 * @Package com.algorithm.leetcode
 * @Description TODO[what the file to do]
 * @Author ali blog:http://www.cnblogs.com/accipiter
 * @Date 2016年2月4日下午4:22:33
 * @Version V1.0.1
 * @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
 */
package com.algorithm.leetcode;

/**
 * @ClassName RemoveDup
 * @Description TODO
 * @Date 下午4:22:33
 */
public class RemoveDup {

	public static void main(String[] args) {
		RemoveDup r=new RemoveDup();
		int a[]={1,1,1,2,2,3};
		int a1[]={4,4,5,6,0,1,2,3};
		System.out.println(r.removeDuplicatesd(a));
		System.out.println(r.searchRoatedSorted(a1, 4));
		System.out.println(r.searchRoatedSortedD(a1, 9));
//		System.err.println(r.removeDuplicates(a));
	}
	/**
	* @Title removeDuplicates
	* @Description 删除重复元素
	* @param a
	* @Return int
	* @Throws 
	* @user Administrator
	* @Date 2016年2月4日
	 */
	public int removeDuplicates(int a[]){
		if(a.length==0){
			return 0;
		}
		int index=0;
		for(int i=0;i<a.length;i++){
			if(a[index]!=a[i]){
				a[++index]=a[i];
			}
		}
		return index+1;
	}

	/**
	* @Title removeDuplicatesd
	* @Description 最多出现两次
	* @Return int
	* @Throws 
	* @user Administrator
	* @Date 2016年2月4日
	 */
	public int removeDuplicatesd(int a[]){
		if(a.length==0){
			return 0;
		}
		int index=0;
		int occur=1;
		for(int i=0;i<a.length;i++){
			if(a[index]==a[i]){
				if(occur<2){
					a[++index]=a[i];
					occur++;
				}
			}else{
				a[++index]=a[i];
				occur=1;
			}
		}
		return index+1;
	}
	/**
	* @Title searchRoatedSorted
	* @Description 查找旋转排序数组
	* @Return int
	* @Throws 
	* @user Administrator
	* @Date 2016年2月4日
	 */
	public int searchRoatedSorted(int []a,int target){
		int first=0,last=a.length;
		while(first!=last){
			int mid=(first+last)>>1;
			if(a[mid]==target){
				return mid;
			}else if(a[first]<=a[mid]){
				if(a[first]<=target&&target<a[mid]){
					last=mid;
				}else{
					first=mid+1;
				}
			}else{
				if(a[mid]<target&&target<=a[last-1]){
					first=mid+1;
				}else{
					last=mid;
				}
			}
		}
		return -1;
	}
	/**
	* @Title searchRoatedSortedD
	* @Description 有重复数据的查找
	* @Return int
	* @Throws 
	* @user Administrator
	* @Date 2016年2月4日
	 */
	public boolean searchRoatedSortedD(int []a,int target){
		int first=0,last=a.length;
		while(first!=last){
			int mid=(first+last)>>1;
			if(a[mid]==target){
				return true;
			}else if(a[first]<a[mid]){
				if(a[first]<=target&&target<a[mid]){
					last=mid;
				}else{
					first=mid+1;
				}
			}else if(a[first]>a[mid]){
				if(a[mid]<target&&target<=a[last-1]){
					first=mid+1;
				}else{
					last=mid;
				}
			}else{
				first++;
			}
		}
		return false;
	}
}
