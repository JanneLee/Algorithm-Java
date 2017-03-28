/**
 * Project Name:Algorithm
 * File Name:Union.java
 * Package Name:com.algorithm.list
 * Date:2014年4月1日下午11:02:23
 * Copyright (c) 2014, janneleemac@gmail.com All Rights Reserved.
 *
*/
/**
 * Project Name:Algorithm
 * File Name:Union.java
 * Package Name:com.algorithm.list
 * Date:2014年4月1日下午11:02:23
 * @version 0.1
 * @author Janne Lee
 * Copyright (c) 2014, janneleemac@gmail.com All Rights Reserved.
 */

package com.algorithm.list;

import java.util.LinkedList;

/**
 * ClassName:Union <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 Use the link list for two union.
 * Date:     2014年4月1日 下午11:02:23 <br/>
 * @author   Administrator
 * @version  
 * @param <E>
 * @since    JDK 1.6
 * @see 	 
 */
public class Union<E> {

	/**
	 * main:(Simply description of this method.). <br/>
	 * TODO(the case of this method – option).<br/>
	 * TODO(the flow of this method – option).<br/>
	 * TODO(the use of this method – option).<br/>
	 * TODO(the notice of this method – option).<br/>
	 *
	 * @author Administrator
	 * @param args
	 * @since JDK 1.6
	 */
	public static void main(String[] args) {
		LinkedList<String> la=new LinkedList<>();
		LinkedList<String> lb=new LinkedList<>();
		la.add("1");
		la.add("2");
		la.add("3");
		la.add("4");
		la.add("5");
		lb.add("5");
		lb.add("5");
		lb.add("7");
		lb.add("8");
		unionList(la,lb);
		for(int i=0;i<la.size();i++){
			System.out.println(la.get(i));
		}
	}
	
	private static void unionList(LinkedList<String> la,LinkedList<String> lb){
		int lb_len=lb.size();
		for(int i=0;i<lb_len;i++){
			String e=lb.get(i);
			if(!la.contains(e)){
				la.add(e);
			}
		}
	}
}

