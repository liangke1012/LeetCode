package leetcode.arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] arrs = {1,3,5,6,6,7,9,9,10};
        int k = removeDuplicatesNums(arrs);

    }

    private static int removeDuplicatesNums(int[] arrs) {
        if(arrs.length == 0 || arrs == null) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < arrs.length){
            if(arrs[p] != arrs[q]){
                arrs[p+1] = arrs[q];
                p++;
            }
            q++;
        }
        return p+1;
    }


}
