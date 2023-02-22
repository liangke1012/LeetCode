package leetcode.string;

/**
最多有k个不同字符的最长子字符串
 */
public class leetcode340 {
    public static void main(String[] args) {
        String str = "eceba";
        int k = 3;
        int len = lengthOfLongestSubstringKDistinct(str,k);
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        int left = 0, right = 0, cnt = 0;
        int charSet[] = new int[256];
        int ans = 0;

        while (right < s.length()) {
            // 统计right指向的字符
            // 当字符在窗口内第一次出现时，字符种类数+1，该字符出现次数+1
            if (charSet[s.charAt(right)] == 0) {
                cnt++;
            }
            charSet[s.charAt(right)]++;
            right++;

            // 向右移动left，保持窗口内只有k种不同的字符
            while (cnt > k) {
                charSet[s.charAt(left)]--;
                // 当该字符在本窗口不再出现时，字符种类数-1
                if (charSet[s.charAt(left)] == 0) {
                    cnt--;
                }
                left++;
            }

            // 更新答案
            ans = Math.max(ans, right - left);
        }
        return ans;

    }
}
