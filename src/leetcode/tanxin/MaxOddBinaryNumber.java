package leetcode.tanxin;

public class MaxOddBinaryNumber {
    public static void main(String[] args) {
        String s = "10010";
        String res = maximumOddBinaryNumber(s);
        System.out.println(res);
    }

    private static String maximumOddBinaryNumber(String s) {
        int cnt = s.length() - s.replace("1","").length();
        return "1".repeat(cnt - 1) + "0".repeat(s.length() - cnt) + "1";
    }

}
