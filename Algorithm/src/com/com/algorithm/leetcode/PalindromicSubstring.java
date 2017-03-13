/**
* @FileName PalindromicSubstring.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月26日下午7:35:55
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

/**
 * @ClassName PalindromicSubstring
 * @Description TODO
 * @Date 下午7:35:55
 */
public class PalindromicSubstring {

	public static void main(String[] args) {
		String s="abcbad";
		PalindromicSubstring ps= new PalindromicSubstring();
		System.out.println(ps.longestPalindrome(s));
	}
	/**
	* @Title longestPalindrome
	* @Description Time Limit Exceeded
	* @param 
	* @return 
	* @Return String
	* @Throws 
	* @user Administrator
	* @Date 2016年1月26日
	 */
	public String longestPalindrome(String s) {
		if(s.length()>1000){
			return null;
		}
		int maxlen=0;
		String longestPalin=null;
		for(int i=0;i<s.length();i++){
			for(int j=i;j<s.length();j++){
				String tmp=s.substring(i, j+1);
				if(isPalindrome(tmp)){
					if(j+1-i>maxlen){
						longestPalin=tmp;
						maxlen=j-i+1;
					}
				}
			}
		}
		return longestPalin;
	}
	
	private boolean isPalindrome(String s){
		boolean flag=true;
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
				flag=false;
			}
		}
		return flag;
	}
}
