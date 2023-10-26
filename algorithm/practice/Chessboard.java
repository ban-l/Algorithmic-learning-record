package org.algorithm.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/10/14 15:36
 * @Description: <p>
 */
public class Chessboard {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String[] s = new String[3];
            char[][] c = new char[5][5];
            for (char[] ch : c) {
                Arrays.fill(ch, '#');
            }
            for (int j = 0; j < 3; j++) {
                s[i] = in.next();
                char[] temp = s[i].toCharArray();
                for (int k = 0; k < temp.length; k++) {
                    c[j + 1][k + 1] = temp[k];
                }
            }
            for (char[] ch : c) {
                System.out.println(Arrays.toString(ch));
            }
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (c[j][k] == '*') {
                        if (
                                ((c[j - 1][k] == 'o' || c[j - 1][k] == '#') && (c[j + 1][k] == 'o' || c[j + 1][k] == '#')) ||
                                        ((c[j][k - 1] == 'o' || c[j][k - 1] == '#') && (c[j][k + 1] == 'o' || c[j][k + 1] == '#'))
                        ) {

                        }
                    } else if (c[j][k] == 'o') {

                        if ((c[j - 1][k] == '*' && c[j - 1][k] == '*') || (c[j][k - 1] == '*' && c[j][k + 1] == '*')) {

                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        in.close();
    }
}
