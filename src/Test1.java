import java.util.ArrayList;
import java.util.List;



public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> subsets = getSubSets(nums);
        System.out.println(subsets.toString());
    }

    private static List<List<Integer>> getSubSets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums,0,path,res);
        return res;
    }

    private static void backtracking(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if(index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1,path,res);
            path.remove(path.size() - 1);
        }
    }
}
