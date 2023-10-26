package org.algorithm.sort;

/**
 * 排序抽象类
 *
 * @author lbb
 */
public interface BaseSort {
    /*稳定的排序算法：冒泡排序、插入排序、归并排序和基数排序。

    不是稳定的排序算法：选择排序、快速排序、希尔排序、堆排序。*/

    /**
     * 排序抽象方法
     *
     * @param sourceArray
     * @return
     */
    int[] sort(int[] sourceArray);
}
