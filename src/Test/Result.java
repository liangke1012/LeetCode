package Test;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private Double ture;
    private Double predict;
    private Double loss;
    private List<Double> predictScoreList = new ArrayList<>();
    private List<Double> trueScoreList = new ArrayList<>();
    private List<Double> lossList = new ArrayList<>();

    @Override
    public String toString() {
        return "Result{" +
                "ture=" + ture +
                ", predict=" + predict +
                ", loss=" + loss +
                ", predictScoreList=" + predictScoreList +
                ", trueScoreList=" + trueScoreList +
                ", lossList=" + lossList +
                '}';
    }

    public Double getTure() {
        return ture;
    }

    public void setTure(Double ture) {
        this.ture = ture;
    }

    public Double getPredict() {
        return predict;
    }

    public void setPredict(Double predict) {
        this.predict = predict;
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        this.loss = loss;
    }

    public List<Double> getPredictScoreList() {
        return predictScoreList;
    }

    public void setPredictScoreList(List<Double> predictScoreList) {
        this.predictScoreList = predictScoreList;
    }

    public List<Double> getTrueScoreList() {
        return trueScoreList;
    }

    public void setTrueScoreList(List<Double> trueScoreList) {
        this.trueScoreList = trueScoreList;
    }

    public List<Double> getLossList() {
        return lossList;
    }

    public void setLossList(List<Double> lossList) {
        this.lossList = lossList;
    }
}
