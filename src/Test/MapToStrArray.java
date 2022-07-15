package Test;

import java.util.*;

public class MapToStrArray {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap();
        map.put("A", "ABC");
        map.put("K", "KK");
        map.put("L", "LV");
        List<Long> features = new ArrayList<>();
        features.add(1234L);
        features.add(2414L);
        features.add(432412L);
        map.put("fids",ListToStr(features));
        map.put("dae","1000");


        StringBuilder sb = new StringBuilder();
        String resultString = "";
        boolean flag = false;
        for(String key : map.keySet()){
            if (flag) {
                sb.append("\t");
            } else {
                flag = true;
            }
            sb.append(map.get(key));
        }
        resultString = sb.toString();
        System.out.println("最后拼接的字符串结果：" + resultString);


    }

    public static String ListToStr(List<Long> list){
        StringBuilder sb = new StringBuilder();
        String resultString = "";
        boolean flag = false;

        for (Long str : list) {
            if (flag) {
                sb.append(",");

            } else {
                flag = true;

            }

            sb.append(Long.toString(str));
        }
        resultString = sb.toString();
        return resultString;
    }
}
