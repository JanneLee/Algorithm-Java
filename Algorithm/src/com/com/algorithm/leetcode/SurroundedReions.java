/**
* @FileName SurroundedReions.java
* @Package com.algorithm.leetcode
* @Description TODO[what the file to do]
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 2016��1��23������10:41:52
* @Version V1.0.1
* @Copyright Copyright (C) 2016 jannelee <janneleemac@gmail.com>
*/
package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @ClassName SurroundedReions
 * @Description TODO
 * @Date ����10:41:52
 */
public class SurroundedReions {
	public void solve(char[][] board) {
	      if(board==null||board.length==0){
	    	  return;
	      }
	      int m=board.length;
	      int n=board[0].length;
	      
	      for(int i=0;i<m;i++){
	    	  if(board[i][0]=='O'){
	    		  dfs(board,i,0);
	    	  }
	    	  if(board[i][n-1]=='O'){
	    		  dfs(board,i,n-1);
	    	  }
	      }
	      
	      for(int j=0;j<n;j++){
	    	  if(board[0][j]=='O'){
	    		  dfs(board,0,j);
	    	  }
	    	  if(board[m-1][j]=='O'){
	    		  dfs(board,m-1,j);
	    	  }
	      }
	      //����д��
//	      for(int i=0;i<m;i++){
//	    	  for(int j=0;j<n;j++){
//	    		  if(board[i][j]=='O'){
//	    			  if(i==0||j==0||i==m-1||j==n-1){
//		    			  dfs(board,i,j);
//		    		  }
//	    		  }
//	    	  }
//	      }
	      print(board);
	      System.out.println("===============");
	      for(int i=0;i<m;i++){
	    	  for(int j=0;j<n;j++){
	    		  if(board[i][j]=='O'){
	    			  board[i][j]='X';
	    		  }else if(board[i][j]=='#'){
	    			  board[i][j]='O';
	    		  }
	    	  }
	      }
	      print(board);
	 }
	 /**
	 * @Title dfs
	 * @Description ���õݹ�ᱨjava.lang.StackOverflowError���󡣷ǵݹ�ʵ�ֵ�ʱ����if�м���continue��֮��ò�����ȷ�����
	 * @param board
	 * @param i
	 * @param j 
	 * @Return void
	 * @Throws 
	 * @user Administrator
	 * @Date 2016��1��24��
	  */
	 public void dfs(char[][]board,int i,int j){
//		 if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
//			 return;
//		 }else{
//			 board[i][j]='#';
//			 
//			 dfs(board,i-1,j);
//			 dfs(board,i+1,j);
//			 dfs(board,i,j-1);
//			 dfs(board,i,j+1);
//		 } 
		 //�ǵݹ�ʵ��
		 Stack<Pos> s=new Stack<Pos>();
		 Pos pos=new Pos(i,j);
		 s.push(pos);
		 board[i][j]='#';
		 int m=board.length;
		 int n=board[0].length;
		 while(!s.isEmpty()){
			 Pos top=s.pop();
			 if(top.x>0&&board[top.x-1][top.y]=='O'){
				 Pos up=new Pos(top.x-1,top.y);
				 s.push(up);
				 board[up.x][up.y]='#';
			 }
			 if(top.x<m-1&&board[top.x+1][top.y]=='O'){
				 Pos down=new Pos(top.x+1,top.y);
				 s.push(down);
				 board[down.x][down.y]='#';
			 }
			 if(top.y>0&&board[top.x][top.y-1]=='O'){
				 Pos left=new Pos(top.x,top.y-1);
				 s.push(left);
				 board[left.x][left.y]='#';
			 }
			 if(top.y<n-1&&board[top.x][top.y+1]=='O'){
				 Pos right=new Pos(top.x,top.y+1);
				 s.push(right);
				 board[right.x][right.y]='#';
			 }
		 }
	 }
	 private class Pos{
		 int x,y;
		 public Pos(int x,int y){
			 this.x=x;
			 this.y=y;
		 }
	 };
	 
	 public void print(char [][]board){
		 for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	 }
	 
	public static void main(String[] args) {
//		char board[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char board[][]={{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
//		char board[][]={{'X','O','O','O'},{'O','X','O','O'},{'O','O','X','O'},{'O','X','O','O'}};
		SurroundedReions s=new SurroundedReions();
		s.print(board);
		System.out.println("==================");
		s.solve(board);
	}
}
