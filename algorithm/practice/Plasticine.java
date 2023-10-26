package org.algorithm.practice;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/4 08:50
 * @Description: <p>
 * 题目描述:
 * 酷酷的小明准备和小伙伴们展示他捏出来的超酷的橡皮泥士兵。
 * 在展示之前，小明发现有些橡皮泥士兵大小十分相似甚至相同，这让小明感觉不是很酷，因为小明想要他的橡皮泥作品都有自己的风格，即使是大小也要有区别。
 * 小明的n个橡皮泥士兵的大小分别为a1,a2...an，小明可以通过给某个士兵加一单位橡皮泥来使得其大小增加一单位。
 * 小明想知道如果他想要让所有的橡皮泥士兵大小都不相同，至少需要一共加多少单位橡皮泥。
 * <p>
 * 输入描述:
 * 第一行1个整数，表示小明的橡皮泥士兵数量
 * 第二行n个整数a1,a2,...an,分别表示小明的橡皮泥士兵的大小。
 * 对于100%的数据，1≤n≤50000,1≤ai≤100000
 * 输出描述:
 * 输出一行一个整数表示总共至少加多少单位的橡皮泥.
 * <p>
 * 样例输入:
 * 5
 * 1 1 2 3 3
 * 样例输出:
 * 5
 * <p>
 * 提示:
 * 我们给一个大小为1的橡皮泥士兵增加4单位橡皮泥，大小变为5;
 * 再给一个大小为3的橡皮泥士兵增加1单位橡皮泥，大小变为4。
 * 此时橡皮泥士兵们的大小分别为1、2、3、4、5，没有两个橡皮泥士兵拥有相同大小了。
 * 可以证明没有更优方案。
 */
public class Plasticine {
    private static int solution(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1] + 1;
                res += nums[i] - temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5, 5, 5};
        int res = solution(nums);
        System.out.println(res);

    }
}
