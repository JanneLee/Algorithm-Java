/**
 *Problem:
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * 问题：
 * 给定n个非负整数a1，a2，...，an，
 * 其中每个表示坐标（i，ai）处的点。
 * 绘制n条垂直线，使得线i的两个端点在（i，ai）和（i，0）。
 * 找到两条线，它们与x轴一起形成容器，使得容器包含最多的水。
 */

package com.algorithm.leetcode;

/**
 * Created by lijianli on 2017/3/13.
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height={1,2,4,5,8,3,5,9,1};
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }
    public static int maxArea(int[] height ){
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
    public static int maxArea1(int[] height){
        int mxArea = 0;
        int left = 0, right = height.length-1;
        while(left<right) {
            int curArea = Math.min(height[left],height[right])*(right-left);
            mxArea = Math.max(curArea,mxArea);
            if(height[left]<height[right])
                left++;
            else if(height[left]>height[right])
                right--;
            else {
                left++;
                right--;
            }
        }
        return mxArea;
    }
}
