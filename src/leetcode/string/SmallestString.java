package leetcode.string;

public class SmallestString {
    public static void main(String[] args) {
        String str = "cbabc";
        String res = smallestString(str);
        System.out.println(res);
    }

    private static String smallestString(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] > 'a') {
                // 继续向后遍历
                for (; i < n && s[i] > 'a'; i++) {
                    s[i]--;
                }
                return new String(s);
            }
        }
        // 所有字母均为 a
        s[n - 1] = 'z';
        return new String(s);
    }

}
