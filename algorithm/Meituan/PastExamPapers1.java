package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 1.小美的外卖订单
 *
 * 小美正在设计美团外卖的定价信息。已知外卖定价的规则如下：
 * 1. 每道菜有折扣价和原价。折扣价不能超过原价。
 * 2. 订单有满x元减y元的优惠。当购买的菜的价格总和不小于 x元时，总价格可以减y元。“减”的价格不能超过“满”的价格。
 * 3. 满减优惠和折扣价是互斥的，当且仅当每个菜都选择了原价才可以触发满减。
 * 4. 系统会自动为客户计算最低价格的方案。
 * <p>
 * 在设计定价时，原价、折扣价和满减的价格都必须是 正实数 。如果设计的定价发生问题，则会提示数据错误。
 * <p>
 * 输入描述：
 * 第一行输入一个正整数n，代表菜的总数。
 * 接下来的n行，每行输入两个实数a_i和b_i，代表每道菜的原价是a_i，折扣价是b_i。
 * 最后一行输入两个实数x和y，代表满x元可以减y元。
 * <p>
 * 数据中所有实数的绝对值不超过1000。
 * <p>
 * 输出描述：
 * 如果数据有误，则输出一行字符串"error"。
 * 否则输出一个小数，小数点后保留2位即可。该小数代表顾客购买了全部菜各一份时，订单的总价格。
 */
public class PastExamPapers1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n道菜
        double[][] a = new double[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextDouble(); // 原件
            a[i][1] = in.nextDouble(); // 折扣价
            // 折扣价不能超过原价
            if (a[i][0] < a[i][1] || a[i][0] <= 0 || a[i][1] <= 0) {
                System.out.println("error");
                return;
            }
        }
        // 满x元可以减y元
        double x = in.nextDouble();
        double y = in.nextDouble();
        in.close();
        // “减”的价格不能超过“满”的价格。
        if (x < y || x <= 0 || y <= 0) {
            System.out.println("error");
            return;
        }

        double ori = 0;
        double dis = 0;
        for (int i = 0; i < n; i++) {
            ori += a[i][0];
            dis += a[i][1];
        }
        if (ori >= x) {
            ori -= y;
        }
        double res = ori > dis ? dis : ori;
        System.out.printf("%.2f", res);
    }
}
