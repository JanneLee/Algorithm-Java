/**
 * FileName:SudokuRecursive.java
 * Date:2014年3月6日
 * Author:Administrator
 * Version:1.0
 */
package com.algorithm.sudoku;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;

/**
 * @author Administrator
 *
 */
public class SudokuRecursive {
	ArrayList<JTextField> list = new ArrayList<JTextField>();   // 数独的格子
	ArrayList<ArrayList<Integer>> insertArray = new ArrayList<ArrayList<Integer>>();
	/**
	 * <li> 生成一个随机的填满的数独
	 * 		private void solution(int index, ArrayList<ArrayList<Integer>> insertArray)
	 * <p><p><P> 描述: 通过递归的方式生成一个随机的填满的数独，实现原理是首先通过传入的下标判断当前位置是否有可以填入
	 * 的数字，如果有将当前数字填入，并将当前的可填入的数字的集合（出去已经填入的数字）保存到方法的另一个参数ArrayList<ArrayList<Integer>> insertArray
	 * 中，再递归。否则尝试修改前一个坐标的下的填入的数字，如果前一个坐标下的对应的ArrayList<ArrayList<Integer>> insertArray中的ArrayList<Integer>中还有可
	 * 插入的数字则修改前一个坐标下的数字，再递归，否则将前一个位置中的内容置空，将递归起点指定到前一位置，然后递归。（其中，如果当前位置上的ArrayList<ArrayList<Integer>> insertArray
	 * 中包含了当前位置的可插入数字的集合，则表示本次递归为上次插入不成功导致的，所以将该数字的集合当做当前可插入的数字的集合，这样一方面可以减少重复判断的次数
	 * 提高代码效率，同时使代码逻辑合理）
	 * @param index list的下标
	 * @param insertArray 可插入数字的集合（已经去掉已插入的)的集合
	 */
	@SuppressWarnings("unused")
	private void solution(int index, ArrayList<ArrayList<Integer>> insertArray) {
		if (index>80) return;
		else {
			ArrayList<Integer> insert = insertable(index/9, index%9);
			if (insertArray.size()>index) insert = insertArray.remove(index);  // 次步骤非常关键，
			if (insert.size()>0) {
				list.get(index).setText(insert.remove(0).toString());
				insertArray.add(insert);
				solution(++index, insertArray); // dg
			}
			else {
				--index;
				ArrayList<Integer> preInsert = insertArray.get(index);
				if (preInsert.size()>0) {
					list.get(index).setText(insertArray.get(index).remove(0).toString());
					solution(++index, insertArray); // dg
				}
				else {
					list.get(index).setText("");
					solution(index, insertArray); //dg
				}
			}
		}
	}
	
	/**
	 * description：随机生成 from-to 的整数
	 * @param from 从哪个数字开始
	 * @param to 到哪个数字结束
	 * @return (int) 随机数
	 */
	@SuppressWarnings("unused")
	private int randomNum(int from, int to) {
		return  from + (int) (Math.random()*(to-from+1));
	}
	/**
	 * description: 获取当前位置可填入的数字
	 * @param indexI	行坐标
	 * @param indexJ	列坐标
	 * @return base 可填入的数字的集合 
	 */
	private ArrayList<Integer> insertable(int indexI, int indexJ) {
		
		ArrayList<Integer> base = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) base.add(i);
		Collections.shuffle(base);
		String str = null;
		// 判断区填入
		int regionI = (indexI/3)*3;
		int regionJ = (indexJ/3)*3;
		for (int i = regionI; i < regionI+3; i++) {
			for (int j = regionJ; j < regionJ+3; j++) {
				str = list.get(i*9+j).getText();	
				// 之后base中只剩下该区中可填的数字
				if (str!=null&&!str.equals("")) { 
					if (base.contains(Integer.parseInt(str)))	
						base.remove(base.indexOf(Integer.parseInt(str)));	
				}
			}
		}
		// 判断行填入
		for (int j = 0; j < 9; j++) {
			str = list.get(indexI*9+j).getText();
			// 之后base中只剩下行中可填入的数字
			if (str!=null&&!str.equals("")) { 
				if (base.contains(Integer.parseInt(str)))
					base.remove(base.indexOf(Integer.parseInt(str)));
			}
		}
		// 判断列填入
		for (int i = 0; i < 9; i++) {
			str = list.get(i*9+indexJ).getText();
			 // 之后base中只剩下列中可填入的数字
			if (str!=null&&!str.equals("")) { 
				if (base.contains(Integer.parseInt(str)))
					base.remove(base.indexOf(Integer.parseInt(str)));
			}
		}
		base.trimToSize();
		return base;
	}
	
}
