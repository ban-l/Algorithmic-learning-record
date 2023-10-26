package org.algorithm.tool;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @Auther: Ban
 * @Date: 2023/4/4 15:14
 * @Description: 显示当前月的日历
 * <p>
 * getMonthValue 几月
 * getDayOfMonth 几号
 * getDayOfWeek 几周
 * getDayOfWeek.getValue 周几
 * <p>
 * plusDays 日期加
 * minusDays 日期减
 * <p>
 * 日期比较方法
 * isAfter
 * isBefore
 * isEqual
 */
public class DateHandle {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue(); // 几月
        int today = date.getDayOfMonth(); // 几号

        date = date.minusDays(today - 1); // 设置为当月月初
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 获得月初是周几， 1 = Monday, . . . , 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth()); // 几号
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1); // 加一天
            // 如果是周一，换行输出
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
