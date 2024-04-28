package leetcode.math;

public class BaseNeg2 {
    public static void main(String[] args) {
        int n =2;
        String res = baseNeg2(n);
        System.out.println(res);
    }

    private static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder str= new StringBuilder();
        while (n != 0) {
            int mod = n % (-2);
            n = n / (-2);
            if (mod == -1) {
                n++;
                mod = 1;
            }
            str.append(mod);
        }
        return str.reverse().toString();
    }
}
