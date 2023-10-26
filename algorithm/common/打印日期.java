package org.algorithm.common;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @Auther: Ban
 * @Date: 2023/3/27 21:07
 * @Description: LocalDate的用法
 * 日历打印
 * 显示当前月的日历
 */
public class 打印日期 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // 获取当前日期，格式：2023-03-27
        System.out.println(date);
        int month = date.getMonthValue(); // 月份
        int today = date.getDayOfMonth(); //天数
        System.out.println(month);
        System.out.println(today);

        date = date.minusDays(today - 1); //设置为这个月的第一天
        System.out.println(date.toString());
        DayOfWeek weekday = date.getDayOfWeek(); // 获取星期几，字符表示
        System.out.println(weekday.toString());
        int value = weekday.getValue(); // 星期几，数字表示
        System.out.println(value);

        System.out.println("Mon Yue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month) {
            // 格式化输出，用 printf
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1); // 若下一天是周一，换行打印
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
