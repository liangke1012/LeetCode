package leetcode.arrays;

public class arrays11 {
    public static void main(String[] args) {
       int[] nums = {1,8,6,2,5,4,8,3,7};
       int area = maxArea(nums);
        System.out.println(area);
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while(l < r){
            int ans = Math.min(height[l],height[r]) * (r - l);
            area = Math.max(ans, area);
            if(height[l] <= height[l]){
                l++;
            }else{
                r--;
            }
        }
       return area;
    }
}
