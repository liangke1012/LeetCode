package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class ShuZuPaiXu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        ArrayList<String> list = new ArrayList<>();
        in.nextLine();
        while( !in.hasNext("#")){
            list.add(in.nextLine());
        }
        String result = paixu(list,length);
        System.out.println(result);
    }

    private static String paixu(ArrayList<String> list, int length) {
        String res = "";
        while ( !isNull(list)){
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if(str == null){
                    continue;
                }
                String[] nums = str.split(",");
                if(nums.length == 0){
                    list.set(i,null);
                }else{
                    if(nums.length < length){
                        res = res + nums + ",";
                        list.set(i,null);
                    }else{
                        for (int j = 0; j < length; j++) {
                            res = res + nums[j] + ",";

                        }
                        String hh = "";
                        for (int k = length; k < nums.length; k++) {
                            if(k == nums.length-1){
                                hh = hh + nums[k];
                            }else{
                                hh = hh + nums[k] + ",";
                            }
                        }
                        list.set(i,hh);
                    }

                }

            }

        }

        return res;
    }

    private static boolean isNull(ArrayList<String> list) {
        int i;
        for ( i = 0; i < list.size(); i++) {
            if(list.get(i) != null){
                break;
            }
        }
        if(i < list.size()){
            return false;
        }else {
            return true;
        }
    }
}
