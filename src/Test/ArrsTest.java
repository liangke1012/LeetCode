package Test;

public class ArrsTest {
    public static void main(String[] args) {
        int[] str = {1,2,3,4,5,6,7,8,9,10};
        int n = 7;
        for(int i = str.length-1; i >= str.length - n; i--){
            System.out.println(str[i]);
        }
    }
}
