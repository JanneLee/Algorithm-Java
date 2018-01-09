package com.algorithm.leetcode.easy;

/**
 *
 * @author lijianli
 * @date 2018/1/9
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(4);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(2);
        l2.next.next=new ListNode(4);

        mergeTwoLists(l1,l2);
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(-1);
        ListNode listNode=result;
        while(l1 !=null && l2 != null){
            if(l1.val<=l2.val){
                listNode.next=l1;
                l1=l1.next;
            }else{
                listNode.next=l2;
                l2=l2.next;
            }
            listNode=listNode.next;
        }
        listNode.next = l1==null?l2:l1;
        return result.next;
    }
}
