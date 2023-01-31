package huawei;

import java.util.Scanner;

public class Zichuan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();

        boolean flag = panduan(str1,str2);
        System.out.println(flag);
    }

    private static boolean panduan(String str1, String str2) {
        String s = str2;
        for (int i = 0; i < str1.length(); i++) {
             char cn = str1.charAt(i);

             if(s.indexOf(cn) == -1){
                 return false;
             }
            s = s.substring(s.indexOf(cn));
        }
        return true;

    }
}
