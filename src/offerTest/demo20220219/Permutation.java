package offerTest.demo20220219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 */
public class Permutation {

    public static void main(String[] args) {
            String s ="qwe";
            String[] str = permutation(s);
        System.out.println(Arrays.toString(str));

    }

    public static String[] permutation(String s){
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(s,list,sb);
        return list.toArray(new String[list.size()]);
    }

    private static void dfs(String s, List<String> list, StringBuffer sb) {
        if(s.length() == sb.length()){
            list.add(new String(sb));
            return;
        }
        for(int i =0;i<s.length();i++){
            String zz = new String(sb);
            if(zz.contains(s.charAt(i)+"")){
                continue;
            }
            sb.append(s.charAt(i));
            dfs(s,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
