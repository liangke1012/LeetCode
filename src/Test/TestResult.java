package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {
    public static void main(String[] args) {
        List<Result> data = new ArrayList<>();
        List<Double> tures = new ArrayList<>();
        List<Double> predicts = new ArrayList<>();
        List<Double> losss = new ArrayList<>();
        List<Double> tures1 = new ArrayList<>();
        List<Double> predicts1 = new ArrayList<>();
        List<Double> losss1 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            tures.add((double) i);
            predicts.add((double) i);
            losss.add((double) i);
        }
        for (int i = 1; i < 4; i++) {
            tures1.add((double) i+1);
            predicts1.add((double) i+1);
            losss1.add((double) i+1);
        }
        Result result = new Result();
        result.setTrueScoreList(tures);
        result.setPredictScoreList(predicts);
        result.setLossList(losss);
        Result result1 = new Result();
        result1.setTrueScoreList(tures1);
        result1.setPredictScoreList(predicts1);
        result1.setLossList(losss1);
        data.add(result);
        data.add(result1);
        Map<Integer,List<Result>> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            List<Result> temp =new ArrayList<>();
            for (Result result2 : data) {
                List<Double> truescorelist = result2.getTrueScoreList();
                List<Double> predcorelist = result2.getPredictScoreList();
                List<Double> lossList = result2.getLossList();
                Result value = new Result();
                value .setTure(truescorelist.get(i));
                value .setPredict(predcorelist.get(i));
                value .setLoss(lossList.get(i));
                temp.add(value );
            }
            map.put(i,temp);
        }

        System.out.println(map.get(2).toString());

    }
}
