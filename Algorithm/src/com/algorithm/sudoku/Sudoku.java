/**
 * FileName:Sudoku.java
 * @author Administrator
 */
package com.algorithm.sudoku;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class Sudoku {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date begin=dfs.parse(dfs.format(new Date()));
         
        String arg = "res/shudu2";
        FileReader rd = new FileReader(arg);
        while (true) {
            Grid grid = Grid.create(rd);
            if (grid == null) {
                break;
            }
            List<Grid> solutions = new ArrayList<Grid>();
            solve(grid, solutions);
            printSolutions(grid, solutions);   
        }
         
        Date end=dfs.parse(dfs.format(new Date()));
        long between=end.getTime()-begin.getTime();
        System.out.println("use Time:"+between+"ms");
    }
 
    private static void solve(Grid grid, List<Grid> solutions) {
 
        if (solutions.size() >= 2) {
            return;
        }
 
        int loc = grid.findEmptyCell();
 
        if (loc < 0) {
            solutions.add(grid.clone());
            return;
        }
 
        for (int n=1; n<10; n++) {
            if (grid.set(loc, n)) {
                solve(grid, solutions);
                grid.clear(loc);
            }
        }
    }
 
    private static void printSolutions(Grid grid, List<Grid> solutions) {
        System.out.println("Original");
        System.out.println(grid);
 
        if (solutions.size() == 0) {
            System.out.println("Unsolveable");
        } else if (solutions.size() == 1) {
            System.out.println("Solved");
        } else {
            System.out.println("At least two solutions");
        }
 
        for (int i=0; i<solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
        System.out.println();
        System.out.println();
    }
}