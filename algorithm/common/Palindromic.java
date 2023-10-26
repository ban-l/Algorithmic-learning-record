package org.algorithm.common;

import java.util.Scanner;

/**
 * 回文串
 * 
 * 完美的代价,计算最少的交换次数使得字符串变成⼀个完美的回文串。
 * 
 * 贪心算法：所求问题的整体最优解可以通过一系列局部最优的选择，即贪心选择来达到。
 * 
 * 局部最优——>整体最优
 * 
 * @author Ban
 *
 */
public class Palindromic {

	// 交换
	private static void swap(char[] s, int a, int b) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}

	/**
	 * 思路：
	 * 
	 * imposible情况： n为偶数，有一个字符出现奇数次； n为奇数，有两个字符（不等）出现奇数次
	 * 
	 * 采用贪心思想，从左向右遍历当前字符串s[i]，然后从右向左遍历找到与当前字符串s[i]相等的字符串s[k]，
	 * 
	 * 将s[k]移到字符串末尾(彼此相邻的移动)，然后将指向末尾的指针减一，i+1。
	 * 
	 * 再看s[i+1]，从右(末尾已经减一)向左遍历找到与其相同的字符再将其移到末尾，再将末尾减一，以此类推。
	 */
	public static void palindromicNumber() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str = in.next();
		char[] c = str.toCharArray();
		in.close();

		int sum = 0;
		int k = n - 1;
		for (int i = 0; i < n; i++) { // 从左到右
			if (k <= i) { // 已是完美回文串
				break;
			}
			for (int j = k; j > i; j--) { // 从右到左
				// 找到匹配的字符
				if (c[i] == c[j]) {
					// 交换，并记录交换次数
					for (int l = j; l < k; l++) {
						swap(c, l, l + 1);
						sum++; // 交换次数+1
					}
					k--; // 尾指针k-1
					break; // 跳出，从i+1开始
				}
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		palindromicNumber();
	}
}
