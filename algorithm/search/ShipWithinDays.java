package org.algorithm.search;

/**
 * @Auther: Ban
 * @Date: 2023/8/12 15:00
 * @Description: <p>
 * 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (find(weights, mid) > days) {
                left = mid + 1;
            } else if (find(weights, mid) < days) {
                right = mid - 1;
            } else if (find(weights, mid) == days) {
                right = mid - 1;
            }
        }
        return left;
    }

    // f(x)，运载能力为x，需要f(x)天运完
    // f(x) 随着 x 的增加单调递减
    public static int find(int[] weights, int x) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > x) { // 一次运不下了
                sum = weights[i];
                res++;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        int res = find(weights, 3);
        System.out.println(res);
    }
}
