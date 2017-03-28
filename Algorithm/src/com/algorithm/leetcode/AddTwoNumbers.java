/**
* @FileName AddTwoNumbers.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016年1月25日下午2:35:28
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

/**
 * @ClassName AddTwoNumbers
 * @Description TODO
 * @Date 下午2:35:28
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		AddTwoNumbers as=new AddTwoNumbers();
		AddTwoNumbers.ListNode l11= as.new ListNode(9);
		AddTwoNumbers.ListNode l12= as.new ListNode(8);
//		AddTwoNumbers.ListNode l13= as.new ListNode(9);
		l11.next=l12;
//    	l12.next=l13;
    	
    	AddTwoNumbers.ListNode l21= as.new ListNode(1);
//		AddTwoNumbers.ListNode l22= as.new ListNode(6);
//		AddTwoNumbers.ListNode l23= as.new ListNode(4);
//		l21.next=l22;
//    	l22.next=l23;
    	
    	ListNode head=as.addTwoNumbers(l11, l21);
    	
    	while(head!=null){
    		System.out.println(head.val);
    		head=head.next;
    	}
	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	 private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode re=null,head=re;
	    int tmp;
	    int flag=0;
		while(l1!=null||l2!=null){
			if(l1==null&&l2!=null){
				tmp=l2.val+flag;
			}else if(l1!=null&&l2==null){
				tmp=l1.val+flag;
			}else{
				tmp=l1.val+l2.val+flag;
			}
	    	if(tmp/10!=0){//进位
	    		ListNode lt=new ListNode(tmp%10);
	    		flag=1;
	    		if(l1==null&&l2!=null){
	    			l1=null;
	    			l2=l2.next;
	    		}else if(l1!=null&&l2==null){
	    			l1=l1.next;
	    			l2=null;
	    		}else{
	    			l1=l1.next;
	    			l2=l2.next;
	    		}
	    		if(re!=null){
	    			re.next=lt;
	    			re=re.next;
	    		}else{
	    			re=lt;
	    			head=re;
	    		}
	    		//最后进位
	    		if(l1==null&&null==l2){
	    			ListNode lt1=new ListNode(tmp/10);
	    			re.next=lt1;
	    			re=re.next;
	    		}
	    	}else{
	    		ListNode lt=new ListNode(tmp%10);
	    		flag=0;
	    		if(l1==null&&l2!=null){
	    			l1=null;
	    			l2=l2.next;
	    		}else if(l1!=null&&l2==null){
	    			l2=null;
	    			l1=l1.next;
	    		}else{
	    			l1=l1.next;
	    			l2=l2.next;
	    		}
	    		if(re!=null){
	    			re.next=lt;
	    			re=re.next;
	    		}else{
	    			re=lt;
	    			head=re;
	    		}
	    	}
	     }
		 return head;
	  }
	 
	 private class ListNode{
		 int val;
		 ListNode next;
		 ListNode(int x){
			 val=x;
		 }
	 };

}
