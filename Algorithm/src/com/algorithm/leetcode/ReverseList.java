/**
* @FileName ReverseList.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016��1��26������1:52:51
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Date ����1:52:51
 */
public class ReverseList {

	public static void main(String[] args) {
		ReverseList rl=new ReverseList();
		ListNode l1= new ListNode(1);
    	ListNode l2= new ListNode(2);
    	ListNode l3= new ListNode(3);
    	ListNode l4= new ListNode(4);
    	l1.next=l2;
    	l2.next=l3;
    	l3.next=l4;
		ListNode head=rl.reverseList(l1);
    	
    	while(head!=null){
    		System.out.println(head.val);
    		head=head.next;
    	}
	}
	public ListNode reverseList(ListNode head) {
		ListNode re=null;
		Stack<ListNode> s=new Stack<ListNode>();
		while(head!=null){
			ListNode tmp=new ListNode(head.val);
        	s.push(tmp);
        	head=head.next;
        }
		ListNode st=null,h=re;
		while(!s.isEmpty()){
			st=s.pop();
			if(re==null){
				re=st;
				h=re;
			}else{
				re.next=st;
				re=re.next;
			}
		}
		return h;
    }

}
