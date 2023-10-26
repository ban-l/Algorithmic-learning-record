package org.algorithm.arr;

/**
 * @Auther: Ban
 * @Date: 2023/4/2 20:17
 * @Description: 前缀和
 */
public class PreSum {
    // 前缀和数组
    public int[] preSum;

    /* 输入一个数组，构造前缀和 */
    public PreSum(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    /**
     * 查询闭区间 [left, right] 的累加和
     * 若left、right为数组下标，结果为：preSum[right + 1] - preSum[left]
     * 若left、right为数字序号，结果为：preSum[right] - preSum[left-1]
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
        // return preSum[right] - preSum[left-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        PreSum p = new PreSum(nums);
        int[][] arr = new int[][]{
                {0, 2},
                {2, 5},
                {0, 5}
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(p.sumRange(arr[i][0], arr[i][1]));
        }
    }
}