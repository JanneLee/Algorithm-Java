/**
 * FileName:Grid.java
 * Date:2014Äê3ÔÂ6ÈÕ
 * Author:Administrator
 * Version:1.0
 */
package com.algorithm.sudoku;

import java.io.Reader;

public class Grid implements Cloneable {
   int[] cells = new int[81];
   int[] colsSet = new int[9];
   int[] rowsSet = new int[9];
   int[] subgridSet = new int[9];
    
   public static Grid create(Reader rd) throws Exception {
       Grid grid = new Grid();
       for (int loc=0; loc<grid.cells.length; ) {
           int ch = rd.read();
           if (ch < 0) {
               return null;
           }
           if (ch == '#') {
               while (ch >= 0 && ch != '\n' && ch != '\r') {
                   ch = rd.read();
               }
           } else if (ch >= '1' && ch <= '9') {
               grid.set(loc, ch-'0');
               loc++;
           } else if (ch == '.' || ch == '0') {
               loc++;
           }
       }
       return grid;
   }


   public int findEmptyCell() {
       for (int i=0; i<cells.length; i++) {
           if (cells[i] == 0) {
               return i;
           }
       }
       return -1;
   }

   
   public boolean set(int loc, int num) {
       // Compute row and column
       int r = loc/9;
       int c = loc%9;
       int blockLoc = (r/3)*3+c/3;

       boolean canSet = cells[loc] == 0
           && (colsSet[c] & (1<<num)) == 0
           && (rowsSet[r] & (1<<num)) == 0
           && (subgridSet[blockLoc] & (1<<num)) == 0;
       if (!canSet) {
           return false;
       }

       cells[loc] = num;
       colsSet[c] |= (1<<num);
       rowsSet[r] |= (1<<num);
       subgridSet[blockLoc] |= (1<<num);
       return true;
   }


   public void clear(int loc) {
       // Compute row and column
       int r = loc/9;
       int c = loc%9;
       int blockLoc = (r/3)*3+c/3;

       int num = cells[loc];
       cells[loc] = 0;
       colsSet[c] ^= (1<<num);
       rowsSet[r] ^= (1<<num);
       subgridSet[blockLoc] ^= (1<<num);
   }


   public Grid clone() {
       Grid grid = new Grid();
       grid.cells = cells.clone();
       grid.colsSet = colsSet.clone();
       grid.rowsSet = rowsSet.clone();
       grid.subgridSet = subgridSet.clone();
       return grid;
   }

   public String toString() {
       StringBuffer buf = new StringBuffer();
       for (int r=0; r<9; r++) {
           if (r%3 == 0) {
               buf.append("-------------------------\n");
           }
           for (int c=0; c<9; c++) {
               if (c%3 == 0) {
                   buf.append("| ");
               }
               int num = cells[r*9+c];
               if (num == 0) {
                   buf.append("0 ");
               } else {
                   buf.append(num+" ");
               }
           }
           buf.append("|\n");
       }
       buf.append("-------------------------");
       return buf.toString();
   }
}