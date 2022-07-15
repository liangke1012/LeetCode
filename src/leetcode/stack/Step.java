package leetcode.stack;

import java.util.Scanner;

public class Step {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str = input.nextLine();
            String[] arr = str.split(" ");
            if(arr.length/2 <= 1){
                System.out.println(-1);
            }
            int ret = step(arr);
            System.out.println(ret);
        }
        input.close();
    }
    private static int step(String[] arr) {
        int min =100;
        int i,j;
        for(i =1;i<arr.length/2;i++){
            int path =0;
            for(j =i;j<arr.length;j+=Integer.parseInt(arr[i])){
                path++;
                if(j==arr.length-1){
                    min = min<path?min:path;
                    break;
                }
            }
        }
        if(min == 100){
            return -1;
        }
        return min;
    }
}


