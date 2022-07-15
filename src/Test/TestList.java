package Test;

import java.util.*;

public class TestList {
    public static void main(String[] args) {

        String a = "1,2,3,4,5";
        String[] str = a.split(",");
        System.out.println(str.length);
        System.out.println(Arrays.toString(str));
        for(int i =0;i<5;i++){
            String name = "";
            name = "abd"+i;
            System.out.println(name);
        }
    }
}
