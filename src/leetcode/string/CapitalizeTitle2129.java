package leetcode.string;

public class CapitalizeTitle2129 {
    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        String res = capitalizeTitle(title);
        System.out.println(res);
    }

    private static String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        for(String str : title.split(" ")) {
            if (ans.length() != 0) {
                ans.append(" ");
            }
            if (str.length() > 2){
                ans.append(str.substring(0,1).toUpperCase());
                str = str.substring(1);
            }
            ans.append(str.toLowerCase());
        }
        return ans.toString();
    }
}
