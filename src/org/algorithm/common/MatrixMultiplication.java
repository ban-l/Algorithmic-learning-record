package org.algorithm.common;

import java.util.Scanner;

/**
 * 矩阵乘法
 *
 * @author Ban
 *
 */
public class MatrixMultiplication {

	public static void name() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// 原始矩阵
		int[][] original = new int[n][n];
		// 记录计算过程矩阵，初始为0
		int[][] record = new int[n][n];
		// 结果矩阵
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				original[i][j] = in.nextInt();
				result[i][j] = original[i][j];
			}
		}
		in.close();

		// 0次幂为单位矩阵
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						System.out.print(1 + " ");
					} else {
						System.out.print(0 + " ");
					}
				}
				System.out.println();
			}
		}

		// m次幂，乘以m-1次
		while (--m > 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int k = 0;
					while (k < n) {
						// 阶乘计算，record记录阶乘
						record[i][j] += result[i][k] * original[k][j];
						k++;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result[i][j] = record[i][j];
					// 一次阶乘后，arr重置0，以防影响结果
					record[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		name();
	}
}
