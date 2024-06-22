package leetcode.string;

public class SmallestBeautifulString {
    public static void main(String[] args) {
        String s = "abfwef";
        int k = 26;
        String res = smallestBeautifulString(s, k);
        System.out.println(res);
    }

    private static String smallestBeautifulString(String str, int k) {
        k += 'a';
        char[] s = str.toCharArray();
        int n = s.length;
        int i = n - 1; // 从最后一个字母开始
        s[i]++; // 先加一
        while (i < n) {
            if (s[i] == k) { // 需要进位
                if (i == 0) { // 无法进位
                    return "";
                }
                // 进位
                s[i] = 'a';
                s[--i]++;
            } else if (i > 0 && s[i] == s[i - 1] || i > 1 && s[i] == s[i - 2]) {
                s[i]++; // 如果 s[i] 和左侧的字符形成回文串，就继续增加 s[i]
            } else {
                i++; // 反过来检查后面是否有回文串
            }
        }
        return new String(s);
    }
}
