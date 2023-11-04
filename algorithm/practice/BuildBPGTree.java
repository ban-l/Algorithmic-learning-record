package org.algorithm.practice;

/**
 * @Auther: Ban
 * @Date: 2023/11/1 21:00
 * @Description: <p>
 * 输入一个长度为2^N(1<=N<=10)的字符串，字符串由{0,1}构成。通过这个字符串我们可以构建一个BPG树。构建方式如下：
 * 1.若这个字符串S即包含0又包含1则该节点的值为G;若这个字符串只包含0则该节点的值为B;若只包含1则该节点的值为P.
 * 2.构建完当前节点，若当前字符串S长度为1则停止构建。否则将S分为左右相等的两个子串S1、S2。按照1的方法构健S1、S2,并作为当前节点的左子树和右子树。
 * <p>
 * 输入：
 * 10001101
 * <p>
 * 输出此二叉树的后续遍历结果:
 * PBGBBBGPPPBPGGG
 */
public class BuildBPGTree {
    public static String buildBPGTree(String str) {
        if (str.contains("0") && str.contains("1")) {
            return "G";
        } else if (str.contains("0")) {
            return "B";
        } else {
            return "P";
        }
    }

    public static String constructTree(String s) {
        if (s.length() == 1) {
            return s.replace("0", "B").replace("1", "P");
        } else {
            int middle = s.length() / 2;
            String left = s.substring(0, middle);
            String right = s.substring(middle);
            String leftSubtree = constructTree(left);
            String rightSubtree = constructTree(right);
            return leftSubtree + rightSubtree + buildBPGTree(s);
        }
    }

    public static void main(String[] args) {
        String inputString = "10001101";
        String result = constructTree(inputString);
        System.out.println(result);
    }
}
