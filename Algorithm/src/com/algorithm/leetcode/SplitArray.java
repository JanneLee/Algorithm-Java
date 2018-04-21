package com.algorithm.leetcode;

/**
 *
 * @author lijianli
 * @date 2018/4/6
 */
public class SplitArray {
    private static boolean guss(long mid,int []nums,int m){
            long sum=0;
            long mm=0;
            for(int i=0;i<nums.length;i++){
                if(sum+nums[i]>mid){
                    ++mm;
                    sum=nums[i];
                    if(nums[i]>mid){
                        return false;
                    }
                }else{
                    sum += nums[i];
                }
            }
            return mm<m;
        }

    public static int splitArray(int[] nums, int m) {
            int n=nums.length;
            long L=0;
            long R=1;

            for(int i=0;i<n;i++){
                R += nums[i];
            }

            long ans=0;
            while(L<R){
                long mid=(L+R)>>1;

                if(guss(mid,nums,m)){
                    ans=mid;
                    R = mid;
                }else{
                    L = mid+1;
                }
            }
            return (int)ans;
        }

    public static void main(String[] args) {
        int[] nums = {1, 2147483646};
        int m=1;
        System.out.println(splitArray(nums,m));
    }
}
