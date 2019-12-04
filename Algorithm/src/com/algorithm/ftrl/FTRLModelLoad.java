package com.algorithm.ftrl;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 模型下载与预测方法
 * n、z、w为需下载的模型参数
 */
public class FTRLModelLoad {

    public double[] n;
    public double[] z;
    public Map<Integer, Double> w;

    /**
     * 模型下载方法
     * 输入：模型文件所在路径
     * 功能：算法全局参数更新
     * */
    public Map<Integer, Double> loadModel(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
        String line;
        String[][] Str = new String[3][];
        int i = 0;
        while((line = br.readLine()) != null) {
            Str[i] = line.split(" ");
            i++;
        }
        if(0==i){
            return new HashMap<>();
        }
        n = new double[Str[0].length];
        z = new double[Str[0].length];
        w = new HashMap<>();
        for(int j=0;j<Str[0].length;j++){
            if(Str[0][j]==null||"null".equals(Str[0][j])){
                n[j]=0D;
            }else{
                n[j] = Double.valueOf(Str[0][j]);
            }
            if(Str[1][j]==null||"null".equals(Str[1][j])){
                z[j]=0D;
            }else{
                z[j] = Double.valueOf(Str[1][j]);
            }
            if(Str[2][j]==null||"null".equals(Str[2][j])){
                w.put(j,0D);
            }else {
                w.put(j,Double.valueOf(Str[2][j]));
            }
        }
        return w;
    }

    /**
     * 预测函数
     * */
    public double predict_(double[] x_,Map<Integer,Double> w) {
        Map<Integer,Double> x = new TreeMap<>();
        for(int i=0;i<x_.length;i++){
            x.put(i,x_[i]);
        }
        double decisionValue = 0.0;
        for (Map.Entry<Integer, Double> e : x.entrySet()) {
            decisionValue += e.getValue() * w.get(e.getKey());
        }
        decisionValue = Math.max(Math.min(decisionValue, 35.), -35.);
        return 1. / (1. + Math.exp(-decisionValue));
    }
}