package leetcode.arrays;

public class lc33 {
    public int search(int[] nums, int target) {

    int n = nums.length;
        if(n ==0) {
        return -1;
    }
        if(n ==1) {
        return nums[0] == target ? 0 : -1;
    }

    int l = 0, r = n - 1;
        while(l <=r) {
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[0] <= nums[mid]) {
            if (nums[0] <= target && target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[n - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
        return-1;
    }

    /**
     * leetcode 81  已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * @param nums
     * @param target
     * @return
     */
    public boolean search1(int[] nums, int target) {
       int n = nums.length;
       if(n == 0){
           return false;
       }
       if(n == 1){
           return nums[0] == target;
       }
       int l = 0,r = n-1;
       while (l<=r){
           int mid = (l+r)/2;
           if(nums[mid] == target){
               return true;
           }
           if(nums[l] == nums[mid] && nums[mid] == nums[r]){
               l++;
               r--;
           }else if(nums[l] <= nums[mid]){
               if(nums[l] <= target && nums[mid] > target){
                   r = mid -1;
               }else{
                   l = mid +1;
               }
           }else {
               if (nums[mid] < target && target <= nums[n - 1]) {
                   l = mid + 1;
               } else {
                   r = mid - 1;
               }
           }
       }
       return false;
    }
}
