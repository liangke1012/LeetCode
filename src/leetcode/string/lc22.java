package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class lc22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateAll(new char[2 * n], 0, list);
        return list;
    }

    private void generateAll(char[] chars, int pos, List<String> list) {
        if(pos == chars.length){
            if(valid(chars)){
                list.add(new String(chars));
            }
        }else {
            chars[pos] = '(';
            generateAll(chars,pos+1,list);
            chars[pos] = ')';
            generateAll(chars,pos+1,list);
        }
    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for(char c : chars){
            if(c == '('){
                ++balance;
            }else {
                --balance;
            }
            if(balance < 0){return false;}

        }
        return balance == 0;
    }

}
