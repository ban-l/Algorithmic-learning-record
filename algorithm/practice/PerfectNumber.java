package org.algorithm.practice;

/**
 * @Auther: Ban
 * @Date: 2023/9/6 21:05
 * @Description: <p>
 * <p>
 * 小红定义一个数为完美数，当且仅当该数仅有一个非零数字
 * 例如 5000.4,1,10,200都星完美数
 * 小红拿到了一个大小为n的数组，她希望选择两个元素，满足它们的乘积为完美数。
 * 小红想知道，共有多少种不同的取法？
 * 数据范围
 * 1<=n<=2000
 * 1<=a<=10^9
 * 示例的
 * 输入
 * [25.21,16]
 * 输出
 * 3
 */
public class PerfectNumber {

    public static boolean check(int v1, int v2) {
        int product = v1 * v2;
        boolean flag = false;
        if (product < 10) {
            flag = true;
        } else if (product % 10 == 0) {
            flag = true;
        }
        return flag;
    }

    private static int solution(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int v1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int v2 = nums[j];
                if (check(v1, v2)) {
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {25, 2, 1, 16};
        int res = solution(nums);
        System.out.println(res);
    }
}
