package com.algorithm.other;

/**
 *
 * @author lijianli
 * @date 2018/5/29
 */
public class LCS {
    public String getLCS(String str1,String str2){
        if(str1==null||str2==null) {
            return "";
        }
        int l1=str1.length();
        int l2=str2.length();
        int [][]c=new int[l1+1][l2+1];
        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                }else{
                    c[i][j]=Math.max(c[i][j-1],c[i-1][j]);
                }
            }
        }
        int i=l1,j=l2;
        StringBuffer sb=new StringBuffer();
        while ((i!=0) && (j!=0)){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(c[i][j-1]>c[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
