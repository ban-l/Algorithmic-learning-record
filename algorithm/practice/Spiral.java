package org.algorithm.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/11/1 19:59
 * @Description: <p>
 * <p>
 * 对每个货架进行编号，编号规则为：从最左上角的货架开始，起始方向向下，由外螺旋向内依次递增编号直至所有货架都编号完成，起始编号为1，具体请参照示例。
 * 输入一个正整数N(1<=N<=100),请按照由上到下，由左到右的顺序输出货架编号。
 * 可以假定个货架正好可以填满一个完整的三角区域。
 * 使用JavaScript语言实现这个方法。
 * <p>
 * 示例
 * 输入
 * 3
 * 输出
 * [1,6,5,2,4,3]
 * <p>
 * 说明
 * 直角边为3的区域如下所示
 * 1 6 5
 * 2 4
 * 3
 * 因此应该顺序输出[1,6,5,2,4,3]
 */
public class Spiral {

    public static void solution(int n) {
        int[][] a = new int[n][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[n - i];
        }
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < n * n / 2) {

        }
    }

    public static void main(String[] args) {
        solution(3);
    }
}
