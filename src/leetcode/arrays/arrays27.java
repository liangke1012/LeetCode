package leetcode.arrays;

public class arrays27 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,4,5};
        int k = removeElement(nums, 4);
        System.out.println(k);
    }

    private static int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0;fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
