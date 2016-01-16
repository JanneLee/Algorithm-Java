package com.algorithm.sudoku;

public class Calc {

	public static void main(String[] args) {
		for(int i=0;i<100000;i++){
			if(i%9==0){
				if(i%8==1){
					if(i%7==5){
						if(i%5==4){
							if(i%4==1){
								System.out.println(i);
							}
						}
					}
				}
			}
		}
	}

}
