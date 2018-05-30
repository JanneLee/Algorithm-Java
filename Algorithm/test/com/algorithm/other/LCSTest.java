package com.algorithm.other;

import org.junit.Test;

/**
 * Created by lijianli on 2018/5/29.
 */
public class LCSTest {
    @Test
    public void getLCSTest(){
        String s1="abcde";
        String s2="bcdefg";
        LCS lcs=new LCS();
        System.out.println(lcs.getLCS(s1,s2));
    }
}
