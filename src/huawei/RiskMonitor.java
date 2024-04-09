package huawei;

public class RiskMonitor {
    int[][] regionRisk = new int[1000][1001];
    int[][] travelArr = new int[1000][1001];

    int[] peopleArr;

    RiskMonitor(int[] people){
        peopleArr = people;
    }

    /**
     * 旅行
     */
    int travel(int data, int peopleId, int regionId){
        if(peopleArr[peopleId] == regionId){
            return 1;
        }
        if(regionRisk[regionId][data] == 1 || travelArr[peopleId][data] == 1){
            return -1;
        }
        peopleArr[peopleId] = regionId;
        return 0;
    }

    /**
     * 新增风险
     */
    void increaseRisk(int data, int regionId){
        for (int i = data; i <= 1000; i++) {
            regionRisk[regionId][i] = 1;
        }
        for (int people = 0; people < peopleArr.length; people++) {
            if(peopleArr[people] == regionId){
                for (int i = data; i <= 1000 ; i++) {
                    travelArr[people][i] = 1;
                }
            }
        }
    }

    /**
     * 接触风险
     */
    void decreaseRisk(int data, int regionId){
        for (int i = data; i <= 1000; i++) {
            regionRisk[regionId][i] = 0;
        }
        for (int people = 0; people < peopleArr.length; people++) {
            if(peopleArr[people] == regionId){
                for (int i = data + 14; i <= 1000 ; i++) {
                    travelArr[people][i] = 1;
                }
            }
        }
    }

    /**
     * 查询人员隔离天数
     */
    int[] query(int data){
        int[] res = new int[peopleArr.length];
        for (int i = 0; i < peopleArr.length; i++) {
            int traveDay = 0;
            for (int j = 0; j <= data; j++) {
                traveDay += travelArr[i][j];
            }
            res[i] = traveDay;
        }
        return res;
    }
}
