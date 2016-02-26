/**
* @FileName LongestSubstring.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月25日下午5:19:17
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LongestSubstring
 * @Description TODO
 * @Date 下午5:19:17
 */
public class LongestSubstring {

	public static void main(String[] args) {
		String s="abcabcbb";
		System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
        	return 0;
        }
        int max=0,left=0;
        Queue<Character> q=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
        	if(q.contains(s.charAt(i))){
        		while(left<i&&s.charAt(left)!=s.charAt(i)){
        			q.remove(s.charAt(left));
        			left++;
        		}
        		left++;
        	}else{
        		q.offer(s.charAt(i));
        		max=Math.max(max,i-left+1);
        	}
        }
		return max;
//		if(s.isEmpty()){
//        	return 0;
//        }
//        HashSet<Character> set = new HashSet<Character>();
//        int leftBound = 0, max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))) {
//                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
//                    set.remove(s.charAt(leftBound));
//                    leftBound ++;
//                }
//                leftBound ++;
//            } else {
//                set.add(s.charAt(i));
//                max = Math.max(max, i - leftBound + 1);
//            }
//        }
//        return max;
    }
}

