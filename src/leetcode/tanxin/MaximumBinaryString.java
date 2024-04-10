package leetcode.tanxin;

public class MaximumBinaryString {
    public static void main(String[] args) {
        String binary = "000110";
        String res = maximumBinaryString(binary);
        System.out.println(res);
    }

    private static String maximumBinaryString(String binary) {
        int i = binary.indexOf('0');
        if (i < 0){
            return binary;
        }
        char[] s = binary.toCharArray();
        int cnt = 0;
        for (i++; i < s.length; i++) {
            cnt += s[i] - '0';
        }
        return "1".repeat(s.length - 1 - cnt) + "0" + "1".repeat(cnt);
    }
}
