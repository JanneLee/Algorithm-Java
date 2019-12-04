package com.algorithm.ftrl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lijianli
 */
public class FTRLLocalTrain {

    private FTRLProximal learner;
    private FTRLModelLoad mload;
    private LogLossEvalutor evalutor;
    private int printInterval;

    public FTRLLocalTrain(FTRLModelLoad mload, FTRLProximal learner, LogLossEvalutor evalutor, int interval) {
        this.mload = mload;
        this.learner = learner;
        this.evalutor = evalutor;
        this.printInterval = interval;
    }

    public void train(String trainFile) throws IOException {
        System.out.println("train file:"+trainFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(trainFile)), "UTF-8"));
        String line;
        int trainedNum = 0;
        double totalLoss = 0.0;
        long startTime = System.currentTimeMillis();
        while((line = br.readLine()) != null) {
            String[] fields = line.split(" ");
            double y = (Integer.parseInt(fields[0]) == 1) ? 1. : -1.;
            Map<Integer, Double> x = new TreeMap<>();
            x.put(0, 1.);
            for(int i=1; i<fields.length; i++) {
                x.put(Integer.parseInt(fields[i]), 1.);
            }

            double p = learner.predict(x);
            learner.updateModel(x, p, y);

            double loss = LogLossEvalutor.calLogLoss(p, y);
            evalutor.addLogLoss(loss);
            totalLoss += loss;

            trainedNum += 1;
            if(trainedNum % printInterval == 0) {
                long currentTime = System.currentTimeMillis();
                double minutes = (double)(currentTime - startTime) / 60000;
                System.out.printf("%.3f, %.5f\n", minutes, evalutor.getAverageLogLoss());
            }
        }
        System.out.printf("global average loss: %.5f\n", totalLoss/trainedNum);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 6) {
            System.out.println("java -jar ftrl_train.jar trainFile L1 L2 alpha dataMaxIndex model\n"
                    + "for example:\n"
                    + "java -jar ftrl_train.jar train 1.0 1.0 0.1 1000 model");
        }
        String trainFile = args[0];
        double L1 = Double.parseDouble(args[1]);
        double L2 = Double.parseDouble(args[2]);
        double alpha = Double.parseDouble(args[3]);
        int dataDimensions = Integer.parseInt(args[4]) + 1;
        String modelPath = args[5];
        double beta = 1.0;
        int testDataSize = 5;
        int interval = 1;
        FTRLParameters paras = new FTRLParameters(alpha, beta, L1, L2, dataDimensions,testDataSize,interval,modelPath);
        FTRLModelLoad mload=new FTRLModelLoad();
        mload.loadModel(modelPath);
        FTRLProximal learner = new FTRLProximal(paras);
        LogLossEvalutor evalutor = new LogLossEvalutor(testDataSize);
        FTRLLocalTrain trainer = new FTRLLocalTrain(mload,learner, evalutor, interval);
        trainer.train(trainFile);
        learner.saveModel(modelPath);
    }
}