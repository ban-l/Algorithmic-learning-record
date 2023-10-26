package org.algorithm.common;

import java.util.Scanner;

/**
 * 进制转换
 *
 * 短除法
 *
 * @author Ban
 *
 */
public class 进制转换 {

	/**
	 * 十进制转十六进制
	 *
	 * 短除法 ，十进制转其他进制，循环取模
	 */
	public static void name() {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();
		char[] arr = new char[10];
		int i = 0;
		while (n != 0) {
			if (n % 16 >= 10) {
				arr[i++] = (char) ('A' + n % 16 - 10);
			} else {
				arr[i++] = (char) ('0' + n % 16);
			}
			n = n / 16;
		}
		for (int j = i - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}
	}

	/**
	 * 十六进制转10进制
	 *
	 * 分割，依次乘以16
	 */
	public static void name2() {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		in.close();
		char[] arr = n.toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A') {
				sum = sum * 16 + (arr[i] - 65 + 10);
			} else {
				sum = sum * 16 + arr[i] - '0';
			}
		}
		System.out.println(sum);
	}

	/**
	 * 16进制转8
	 *
	 * 先16-10,再10-8
	 */
	public static void name3() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.next();
		}
		for (int i = 0; i < arr.length; i++) {
			// 16进制转换10进制
			char[] c = arr[i].toCharArray();
			int sum = 0;
			for (int j = 0; j < c.length; j++) {
				if (c[j] >= 'A') {
					sum = sum * 16 + c[j] - 'A' + 10;
				} else {
					sum = sum * 16 + c[j] - '0';
				}
			}

			// 10进制转换8进制
			int[] array = new int[10];
			int k = 0;
			while (sum != 0) {
				array[k++] = sum % 8;
				sum /= 8;
			}
			for (int j = k - 1; j >= 0; j--) {
				System.out.print(array[j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

	}
}
