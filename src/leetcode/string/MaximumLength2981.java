package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumLength2981 {
    public static void main(String[] args) {
        String s = "aaaabccaa";
        int res = maximumLength(s);
        System.out.println(res);
    }

    private static int maximumLength(String s) {
        int ans = -1;
        int len = s.length();

        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<Integer>();
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;
            if (i + 1 == len || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;

                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }

                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i].size() > 0 && chs[i].get(0) > 2) {
                ans = Math.max(ans, chs[i].get(0) - 2);
            }
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            if (chs[i].size() > 2) {
                ans = Math.max(ans, chs[i].get(2));
            }
        }

        return ans;
    }
}
