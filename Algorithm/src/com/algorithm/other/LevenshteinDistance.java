package com.algorithm.other;

/**
 *
 * @author lijianli
 * @date 2020/1/7
 */
public class LevenshteinDistance {
    public static void main(String[] args) {
        String a = "kitten";
        String b = "sitting";
        int re1 = distance(a, a.length(), b, b.length());
        int re2=distance(a,b);
        System.out.println(re1);
        System.out.println(re2);

    }
    public static int distance(String a,int len_a,String b,int len_b){
        if(len_a==0){
            return len_b;
        }
        if(len_b==0){
            return len_a;
        }
        int cos;
        if(a.charAt(len_a-1)==b.charAt(len_b-1)){
            cos=0;
        }else{
            cos=1;
        }

        int re1=distance(a,len_a-1,b,len_b)+1;
        int re2=distance(a,len_a,b,len_b-1)+1;
        int re3=distance(a,len_a-1,b,len_b-1)+cos;

        return re1<re2?(re1<re3?re1:re3):(re2<re3?re2:re3);
    }
    public static int distance(String a, String b) {
        int[][] dis = new int[a.length()+1][b.length()+1];
        for (int i = 1; i <= a.length(); i++)
            dis[i][0] = i;
        for (int j = 1; j <= b.length(); j++)
            dis[0][j] = j;
        int cas;
        for (int j = 1; j <= b.length(); j++) {
            for (int i = 1; i <= a.length(); i++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    cas = 0;
                } else {
                    cas = 1;
                }
                int re = Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1);
                dis[i][j] = Math.min(re, dis[i - 1][j - 1] + cas);
            }
        }
        return dis[a.length() - 1][b.length() - 1];
    }
}
