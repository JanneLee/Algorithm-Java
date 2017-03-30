package com.algorithm.list;

/**
 * Created by lijianli on 2017/3/30.
 */
public class ReverseList {
    public static void main(String[] args){
        print(recursionReverse(reverse(init(10))));
    }
    private static Node<Integer> init(int num){
        Node<Integer> node=new Node(0,null);
        Node<Integer> cur=null;
        Node<Integer> tmp;
        for(int i=1;i<num;i++){
            tmp=new Node<>(i,null);
            if(i==1){
                node.setNextNode(tmp);
            }else{
                cur.setNextNode(tmp);
            }
            cur=tmp;
        }
        return node;
    }
    private static void print(Node head){
        Node tmp=head;
        while (tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextNode();
        }
    }

    private static Node<Integer> reverse(Node head){
        if(head==null){
            return head;
        }
        Node pre=head;
        Node cur=head.getNextNode();
        Node next;
        while(cur!=null){
            next=cur.getNextNode();
            cur.setNextNode(pre);

            pre=cur;
            cur=next;
        }
        head.setNextNode(null);
        head=pre;
        return head;
    }

    private static Node<Integer> recursionReverse(Node current){
        if(current==null||current.getNextNode()==null){
            return current;
        }
        Node nextNode=current.getNextNode();
        current.setNextNode(null);
        Node reverseNode=recursionReverse(nextNode);
        nextNode.setNextNode(current);
        return reverseNode;
    }
}
