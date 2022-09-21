package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class String03 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        int len = lengthOfLongestSubstring(s1);
    }

    private static int lengthOfLongestSubstring(String s1) {
        Set<Character> occ = new HashSet<Character>();
        int n = s1.length();
        int r = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if( i != 0){
                occ.remove(s1.charAt(i - 1));
            }
            while(r + 1 < n && !occ.contains(s1.charAt( r + 1))){
                occ.add(s1.charAt(r +1));
                ++r;
            }
            ans = Math.max(ans,r - i +1 );
        }
        return ans;
    }
}
