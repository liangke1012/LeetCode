package huawei;

import java.util.*;

/**
 * 单词数组paramArr，对这些单词按进行词分组，并输出分组中元素最多的一组
 */
public class GetSimilarWords {
    public static void main(String[] args) {
        String[] word = {"ba", "tan", "nat", "eat", "tea", "ate", "ant"};
        List<String> words = Arrays.asList(word);
        List<String> similarWords = getSimilar(words);
        System.out.println(similarWords);
    }

    private static List<String> getSimilar(List<String> words) {
        Map<String, List<String>> s = new HashMap<>();

        int cnt = 0;
        for (String w : words) {
            byte[] bytes = w.getBytes();
            Arrays.sort(bytes);
            String str = new String(bytes);
            if (!s.containsKey(str)){
                s.put(str, new ArrayList<>());
            }
            s.get(str).add(w);
            if(s.get(str).size() > cnt){
                cnt = s.get(str).size();
            }
        }

        List<String> ans = null;
        int index = words.size();
        for(Map.Entry<String, List<String>> e : s.entrySet()){
            if (e.getValue().size() == cnt) {
                int idx = words.indexOf(e.getKey());
                System.out.println(e.getKey());
                System.out.println(idx);
                if(idx < index){
                    index = idx;
                    ans = e.getValue();
                }
            }
        }
        return ans;
    }
}
