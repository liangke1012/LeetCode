package leetcode.arrays;

public class lc34{
    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int BinarySearch(int[] nums,int left,int right,int val){
        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midVal = nums[mid];
        if(midVal < val){
            return BinarySearch(nums,mid+1,right,val);
        } else if (midVal > val) {
            return BinarySearch(nums,left,mid-1,val);
        }else {
            return mid;
        }
    }

    /**
     * 二分查找 方法2
     */
    public int BinarySearch(int[] nums,int target,boolean lower){
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * leetcode 34 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        //二分查找中，寻找 leftIdx即为在数组中寻找第一个大于等于 target 的下标，
        // 寻找 rightIdx即为在数组中寻找第一个大于 target的下标，然后将下标减一。
        int leftIdx = BinarySearch(nums,target,true);
        int rightIdx = BinarySearch(nums,target,false)-1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};


    }

}
