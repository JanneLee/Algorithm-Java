/**
 * 二叉树的递归遍历，非递归遍历，已经衍生出来的其他问题。
 */
package com.algorithm.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * @author Administrator
 */
public class BinaryTree {
	
	private int data[]={1,2,3,5,9,8,5};
	private static List<TreeNode> nodeList=null;
	/**
	 * 创建B树
	 */
	public void createBTree(){
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
        // 左孩子  
        nodeList.get(lastParentIndex).leftTree = nodeList  
                .get(lastParentIndex * 2 + 1);  
        if (data.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightTree = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        } 
	}
	/**
	 * 中序遍历
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
	 * 递归实现树的求和。
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
	 * 非递归实现中序遍历
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
		bt.createBTree();
		bt.inOrderTraverse(nodeList.get(0));
		System.out.println("\n+++++++++++++");
		System.out.println(bt.sum(nodeList.get(0)));
		System.out.println("\n+++++++++++++");
		bt.noRecInOrder(nodeList.get(0));
		System.out.println("\n+++++++++++++");
		System.out.println(bt.noRecSum(nodeList.get(0)));
	}
	
	/**
	 * 内部内，主要构造为树的节点。
	 */
	private static class TreeNode{
		private TreeNode leftTree;
		private TreeNode rightTree;
		private int data;
		private boolean isVisted=false;//是否已经访问标识
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
