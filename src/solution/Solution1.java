package solution;

import java.util.HashMap;

/**
 * 前缀和题目
 */
public class Solution1 {
    /**
     * 303 二维区域和检索-数组不可变
     */
    class NumArray {

        private int[] nums;

        private int[] preSum;

        public NumArray(int[] nums) {
            this.nums = nums;
            //前缀和数组
            preSum = new int[nums.length + 1];
            for(int i = 1; i < nums.length + 1; i++){
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

    /**
     * 304 二维区域和检索-矩阵不可变
     */
    static class NumMatrix {

        private int[][] matrix;

        private int[][] preMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            this.matrix = matrix;
            preMatrix = new int[matrix.length + 1][matrix[0].length + 1];
            //构造前缀和矩阵
            for(int i = 1; i < matrix.length + 1; i++){
                for(int j = 1; j < matrix[0].length + 1; j++){
                    preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1]
                            + matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preMatrix[row2 + 1][col2 + 1] - preMatrix[row1][col2 + 1]
                    - preMatrix[row2 + 1][col1] + preMatrix[row1][col1];
        }
    }

    /**
     * 560 和为k的数组
     */
    public int subarraySum(int[] nums, int k) {
        //构造前缀和数组
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        //列举所有子数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(preSum[j + 1] - preSum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 和为k的数组-优化
     */
    public static int subarraySum2(int[] nums, int k){
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);
        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j))
                res += preSum.get(sum0_j);
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3},{2,3,4},{1,1,1}};
//        NumMatrix obj = new NumMatrix(matrix);
//        int param = obj.sumRegion(1,1,2,2);
//        System.out.println(param);

        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum2(nums,2));
    }
}
