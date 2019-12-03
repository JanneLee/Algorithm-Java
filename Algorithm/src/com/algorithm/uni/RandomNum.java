package com.algorithm.uni;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lijianli on 2019/8/29.
 */
public class RandomNum {
    public static void main(String[] args) {
        for(int i=0;i< 1000L;i++){
            System.out.println(String.format("%.2f",ThreadLocalRandom.current().nextDouble()));
        }
    }
}
