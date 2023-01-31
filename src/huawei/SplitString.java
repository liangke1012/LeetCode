package huawei;

import java.util.Locale;
import java.util.Scanner;

public class SplitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int k = Integer.parseInt(sc.nextLine());
            String[] strings = sc.nextLine().split("-");
            String s = "";
            for (int i = 1; i < strings.length; i++) {
                s = s + strings[i];
            }
            int index = 0;
            StringBuffer buffer = new StringBuffer();
            buffer.append(strings[0]);
            while (s.length() - index > k) {
                buffer.append("-" + caseConversion(s.substring(index, index + k)));
                index += k;
            }
            if (s.length() - index > 0) {
                buffer.append("-" + caseConversion(s.substring(index)));
            }
            System.out.println(buffer);
        }
    }

    private static String caseConversion(String s) {
        int upperCaseLength = s.length() - s.replaceAll("[A-Z]", "").length();
        int lowerCaseLength = s.length() - s.replaceAll("[a-z]", "").length();
        if (upperCaseLength > lowerCaseLength) {
            return s.toUpperCase(Locale.ROOT);
        }
        if (lowerCaseLength > upperCaseLength) {
            return s.toLowerCase(Locale.ROOT);
        }
        return s;

    }

}
