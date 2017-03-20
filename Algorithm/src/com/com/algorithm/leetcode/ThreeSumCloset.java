package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lijianli on 2017/3/17.
 */
public class ThreeSumCloset {

    public static void main(String[] args){
        int[] nums={1,1,1,0};
        int target=100;
        System.out.println(threeSumClosest(nums,target));
        System.out.println(1<<13);

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return bestSum;
    }
}
