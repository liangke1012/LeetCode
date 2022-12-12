package leetcode.arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] arrs = {1,3,5,6,6,7,9,9,10};
        int k = removeDuplicatesNums(arrs);
        int[] nums = {1,1,2,2,2,3,3,3,4};
        int m = removeDuplicates(nums);
        System.out.println(m+"");

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

    /**给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * leetcode 80
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n){
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
