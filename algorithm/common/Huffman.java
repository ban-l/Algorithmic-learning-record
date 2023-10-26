package org.algorithm.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/3/20 14:34
 * @Description: Huffuman树构建
 */
public class Huffman {

    /**
     * 构造哈夫曼树
     * 1.找出最小的两个节点，记录
     * 2.删除两个节点，加入新节点
     * 3.重新排序,重复1、2，长度为1时结束
     * 记录新建的节点的权值之和，n-1个新建节点
     *
     * @param list
     */
    public static void construction(List<Integer> list) {
        int sum = 0;
        int size = list.size();
        while (size > 1) {
            Collections.sort(list);
            int temp = list.remove(0) + list.remove(0);
            sum += temp;
            list.add(temp);
            size = list.size();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        in.close();
        construction(list);
    }
}
