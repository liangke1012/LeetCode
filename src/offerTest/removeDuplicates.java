package offerTest;

public class removeDuplicates {
    public static void main(String[] args){
        int[] nums ={0,0,1,1,1,2,2,2,3,4,4,4};
        int len = removeDuplicate(nums);
        System.out.println(len);
    }

    private static int removeDuplicate(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int left = 0;
        for(int right = 1;right<nums.length;right++){
            if(nums[left] != nums[right]){
                nums[++left] = nums[right];
            }

        }
        return ++left;
    }
}
