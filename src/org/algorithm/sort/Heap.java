package org.algorithm.sort;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/4/18 15:18
 * @Description: 二叉堆
 * 大根堆
 * 小根堆
 * 插入
 * 删除
 * 堆排序
 */
public class Heap {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        // 堆排序
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 以大根堆为例
     * 1. 初始化：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
     * 2. 交换：将其与末尾元素进行交换，此时末尾就为最大值，即将最大元素"沉"到数组末端。
     * 3. 调整：重新调整结构，将剩余元素重新构造成一个堆，然后继续交换堆顶元素与当前末尾元素，反复执行交换+调整步骤，直到整个序列有序。
     */


    //堆排序
    public static void sort(int[] a) {
        int n = a.length;
        // 1 初始化堆
        // 调整分支结点（n/2-1 到 0）， 从下至上，从右至左 调整堆结构
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(a, n, i);
        }
        // 2 调整
        // n-1趟的 交换和调整 过程，每次交换堆顶和堆尾元素，元素下标从 n-1 到 1
        for (int i = n - 1; i > 0; i--) {
            // 2.1 交换，a[0]、a[i]，堆顶和堆底元素对调
            swap(a, 0, i);
            // 2.2 调整，以0为根节点，把剩余i个元素整理成堆
            adjust(a, i, 0);
        }
    }

    // 迭代方法：调整堆，此时有 n 个元素，以 i 为根向下调整堆
    public static void adjust(int[] a, int n, int i) {
        // temp 暂存根节点（i）
        int temp = a[i];
        // 从 i结点的 左子结点开始（2 * i+1），沿 i 较大的子结点 向下筛选
        for (int k = 2 * i + 1; k < n; k = 2 * k + 1) {
            // 比较i的左、右子树，取较大节点
            if (k + 1 < n && a[k] < a[k + 1]) {
                k++; // k为较大子结点的下标
            }
            // 根节点（i） 和 子树节点值比较
            if (temp >= a[k]) { // 满足堆定义，筛选结束
                break;
            } else { // 不满足，向下交换
                // 将a[k]调整到 双亲结点上
                a[i] = a[k];
                i = k; // 改变 i值，再次向下比较（交换可能破坏下一级的堆，需要继续向下调整）
            }
        }
        // temp值放入最终位置
        a[i] = temp;
    }

    // 递归方法：调整堆，此时有 n 个元素，以 i 为根向下调整堆
    public static void adjustRecursion(int[] a, int n, int i) {
        int max = i; // 根节点
        int left = 2 * i + 1; // 左孩子节点
        int right = 2 * i + 2; // 右孩子节点
        // 根节点和左、右孩子节点比较
        if (left < n && a[left] > a[max]) {
            max = left;
        }
        if (right < n && a[right] > a[max]) {
            max = right;
        }
        if (max != i) { // 不满足堆定义
            // 交换
            swap(a, i, max);
            // 向下调整
            adjustRecursion(a, n, max);
        }
    }


    // 交换元素
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
