package com.algorithm.sudoku;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Administrator
 *
 */
public class MuiltiAdd {

	   public static void main(String[] args) throws Exception {
	        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        Date begin=dfs.parse(dfs.format(new Date()));
	         
	        int a[][] = new int[4][4];
	        for(int i=0;i<4;i++){
	        	for(int j=0;j<4;j++){
	        		a[i][j]=0;
	        	}
	        }
	        Random r = new Random(begin.getTime());
	        
	        int number=(r.nextInt(5)%2)*2+2;
	        int number1=(r.nextInt(5)%2)*2+2;
	        int number2=(r.nextInt(5)%2)*2+2;
	        
	        int l=r.nextInt(16);
	        int k=r.nextInt(16);
	        while(l==k){
	        	k=r.nextInt(16);
	        }
	        int l1=l%4,l2=Integer.divideUnsigned(l, 4);
	        int k1=k%4,k2=Integer.divideUnsigned(k, 4);
	        
	        a[l1][l2]=number1;
	        a[k1][k2]=number2;
	        
	        int w=0;
	        while(0==w){
		        for(int i=0;i<4;i++){
		        	for(int j=0;j<4;j++){
		        		for(int m=i+1;m<4;m++){
		        			for(int n=j+1;n<4;n++){
		        				if(a[i][j]==a[m][j]){
		        					a[i][j]=2*a[i][j];
		        					a[m][j]=number;
		        				}
		        				if(a[i][j]==a[i][n]){
		        					a[i][j]=2*a[i][j];
		        					a[i][n]=number;
		        				}
		        			}
		        		}
		        	}
		        }
	        }
	        for(int i=0;i<4;i++){
	        	for(int j=0;j<4;j++){
	        		System.out.print(a[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	        
	        Date end=dfs.parse(dfs.format(new Date()));
	        long between=end.getTime()-begin.getTime();
	        System.out.println("use Time:"+between+"ms");
	    }
	 
}
