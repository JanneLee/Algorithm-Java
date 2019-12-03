package com.algorithm.other;

/**
 *
 * @author lijianli
 * @date 2018/7/3
 */
public class Pi {
    public static void main(String[] args) {
        float N=100000000L;
        int s=0;
        for(int i=0;i<N;i++){
            double x=Math.random();
            double y=Math.random();
            if(x*x+y*y<=1){
              s+=1;
            }
        }
        System.out.println(4.0*s/N);
    }
}
