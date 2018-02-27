package com.algorithm.leetcode.easy;

/**
 *
 * @author lijianli
 * @date 2018/2/26
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int nums[]=new int[]{1,1,1,2};
        System.out.println(removeDuplicates(nums));
        for (int num:nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int tmp;
        int len=1;
        for(int i=0;i<nums.length;i++){
            tmp=nums[i];
            nums[len-1]=tmp;
            for(int j=i+1;j<nums.length;j++){
                if(tmp==nums[j]){
                    i++;
                }else {
                    len++;
                    break;
                }
            }
        }

        return len;
    }
}
