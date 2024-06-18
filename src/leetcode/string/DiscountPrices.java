package leetcode.string;

public class DiscountPrices {
    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        String res = discountPrices(sentence, discount);
        System.out.println(res);
    }

    private static String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            if (word.charAt(0) == '$' && isnumber(word.substring(1))) {
                double price = Long.parseLong(word.substring(1)) * (1 - discount / 100.0);
                strs[i] = String.format("$%.2f", price);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private static boolean isnumber(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
