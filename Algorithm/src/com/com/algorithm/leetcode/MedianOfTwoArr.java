/**
* @FileName MedianOfTwoArr.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月25日下午9:55:07
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

/**
 * @ClassName MedianOfTwoArr
 * @Description TODO
 * @Date 下午9:55:07
 */
public class MedianOfTwoArr {

	public static void main(String[] args) {
		MedianOfTwoArr a=new MedianOfTwoArr();
		int nums1[]={1,3,5,7};
		int nums2[]={2,4,6,8};
		System.out.println(a.findMedianSortedArrays(nums1, nums2));
	}
	public double findMedianSortedArrays(int nums1[], int nums2[]) {
	    if((nums1.length+nums2.length)>>1==1)
	        return merge(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2+1);
	    else
	        return (merge(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2)  
	               +merge(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2+1))/2.0;
	}
	private int merge(int A[], int B[], int i, int i2, int j, int j2, int k){
	    int m = i2-i+1;
	    int n = j2-j+1;
	    if(m>n)
	        return merge(B,A,j,j2,i,i2,k);
	    if(m==0)
	        return B[j+k-1];
	    if(k==1)
	        return Math.min(A[i],B[j]);
	    //divide k into two parts.
	    int posA = Math.min(k/2,m);
	    int posB = k-posA;
	    if(A[i+posA-1]==B[j+posB-1])
	        return A[i+posA-1];
	    else if(A[i+posA-1]<B[j+posB-1])
	        return merge(A,B,i+posA,i2,j,j+posB-1,k-posA);
	    else
	        return merge(A,B,i,i+posA-1,j+posB,j2,k-posB);
	}
}
