package leetcode.arrays;

public class SearchMatrix {
    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = BinarySearchCol(matrix,target);
        if(rowIndex == -1){
            return false;
        }
        return BinarySearchRow(matrix[rowIndex],target);
    }

    private boolean BinarySearchRow(int[] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;

    }

    private int BinarySearchCol(int[][] matrix, int target) {
        int left = -1,right = matrix.length - 1;
        while (left < right){
            int mid = left + (right-left+1)/2;
            if(matrix[mid][0] <= target){
                left = mid;
            }else {
                right = mid -1;
            }
        }
        return left;
    }
}
