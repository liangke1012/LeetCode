package leetcode.backtract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc17 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res.toString());
    }

    private static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;

    }

    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int i, StringBuffer stringBuffer) {
        if(i == digits.length()){
            combinations.add(stringBuffer.toString());
        }else {
            char digit = digits.charAt(i);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int j = 0; j < lettersCount; j++) {
                stringBuffer.append(letters.charAt(j));
                backtrack(combinations,phoneMap,digits,i+1,stringBuffer);
                stringBuffer.deleteCharAt(i);
            }
        }

    }
}
