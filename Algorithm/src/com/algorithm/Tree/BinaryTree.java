/**
 * �������ĵݹ�������ǵݹ�������Ѿ������������������⡣
 */
package com.algorithm.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * @author Administrator
 */
public class BinaryTree {
	
	private int data[]={1,2,3,5,9,8,5,100,11};
	private static List<TreeNode> nodeList=null;

	public void createBTree(int data[]){
		nodeList = new LinkedList<BinaryTree.TreeNode>();
		
		for(int nodeIndex=0;nodeIndex<data.length;nodeIndex++){
			nodeList.add(new TreeNode(data[nodeIndex]));
		}
		//create as the binary tree.
		for(int parentIndex=0;parentIndex<data.length/2-1;parentIndex++){
			nodeList.get(parentIndex).leftTree=nodeList.get(parentIndex*2+1);
			nodeList.get(parentIndex).rightTree=nodeList.get(parentIndex*2+2);
		}
		int lastParentIndex = data.length / 2 - 1;  
        // ����  
        nodeList.get(lastParentIndex).leftTree = nodeList  
                .get(lastParentIndex * 2 + 1);  
        if (data.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightTree = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        } 
	}
	/**
	 * @param treeNode
	 */
	public void inOrderTraverse(TreeNode treeNode) {  
	        if (treeNode == null)  
	            return;  
	        inOrderTraverse(treeNode.leftTree);  
	        visit(treeNode);  
	        inOrderTraverse(treeNode.rightTree);  
	}
	/**
	 * @param treeNode
	 * @return
	 */
	public int sum(TreeNode treeNode){
		int sum=0;
		if(treeNode == null){
			sum=0;
		}else{
			sum+=treeNode.getData();
			sum+=sum(treeNode.leftTree);
			sum+=sum(treeNode.rightTree);
		}
		return sum;
	}
	/**
	 * @param treeNode
	 */
	public void noRecInOrder(TreeNode treeNode){
		Stack<BinaryTree.TreeNode> stack=new Stack<BinaryTree.TreeNode>();
		while(treeNode!=null||stack.size()>0){
			while(treeNode!=null){
				stack.push(treeNode);
				treeNode=treeNode.leftTree;
			}
			if(stack.size()>0){
				treeNode=stack.pop();
				visit(treeNode);
				treeNode=treeNode.rightTree;
			}
		}
	}
	public int noRecSum(TreeNode treeNode){
		int sum=0;
		Stack<BinaryTree.TreeNode> stack=new Stack<BinaryTree.TreeNode>();
		while(treeNode!=null||stack.size()>0){
			while(treeNode!=null){
				stack.push(treeNode);
				treeNode=treeNode.leftTree;
			}
			if(stack.size()>0){
				treeNode=stack.pop();
				sum+=treeNode.getData();
				treeNode=treeNode.rightTree;
			}
		}
		return sum;
	}
	private void visit(TreeNode treeNode){
		treeNode.setVisted(true);
		System.out.print(treeNode.getData()+" ");
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.createBTree(bt.data);
		bt.inOrderTraverse(nodeList.get(0));
		System.out.println("\n+++++++++++++");
		System.out.println(bt.sum(nodeList.get(0)));
		System.out.println("\n+++++++++++++");
		bt.noRecInOrder(nodeList.get(0));
		System.out.println("\n+++++++++++++");
		System.out.println(bt.noRecSum(nodeList.get(0)));
	}
	
	/**
	 */
	private static class TreeNode{
		private TreeNode leftTree;
		private TreeNode rightTree;
		private int data;
		private boolean isVisted=false;
		TreeNode(int newData){
			this.leftTree=null;
			this.rightTree=null;
			this.data = newData;
			this.setVisted(false);
		}
		public int getData(){
			return data;
		}
		@SuppressWarnings("unused")
		public boolean isVisted() {
			return isVisted;
		}
		public void setVisted(boolean isVisted) {
			this.isVisted = isVisted;
		}
	}
}
