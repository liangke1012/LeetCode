package Test;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abcdefghighk");
        list.add("ddsfgergvgagwvw");
        list.add("dfafsvaswefsvc");
        list.add("dfqwefw");
        Map<Character,Integer> map = new HashMap<>();
        for (String s : list) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    Integer count = map.get(c);
                    count++;
                    map.put(c, count);
                }
            }
        }
        //对map进行排序，得到结果list
        List<Map.Entry<Character,Integer>> res = new ArrayList<>();
        Iterator<Map.Entry<Character,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        Collections.sort(res,new Comparator<Map.Entry<Character ,Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        System.out.println(res);

    }
}
