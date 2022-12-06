package leetcode.string;

import java.util.Arrays;

public class kmp {
    public static void main(String[] args) {
        String s1 = "abadabfabadabd";
        String s2 = "abadabd";
        int[] next = getNext(s2);
        System.out.println(Arrays.toString(next));
        int k = strStr(s1,s2);

    }
    public static int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        for (int i = 0,j=0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i - j +1;
            }
        }
        return -1;
    }

    /**
     * kmp核心算法
     * @param s
     * @return
     */
    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
