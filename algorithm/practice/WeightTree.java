package org.algorithm.practice;

import org.algorithm.tree.TreeNode;

import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/9/12 14:13
 * @Description: <p>
 * 牛牛有一棵二叉树，该二叉树节点的权值为0/1。
 * 牛牛给你这棵二叉树，想让你告诉他该二叉树从根书点到叶子节点的所有路径中，节点"权值1的个数" 比 "权值0的个数" 多 1 的路径有多少条呢。
 * 返回路径数目。
 * 输入
 * {1,0,0,1,0,#,1}
 * 输出
 * 2
 */
public class WeightTree {
    private static LinkedList<Integer> track = new LinkedList<>();
    private static int trackSum = 0;
    private static int res = 0;

    public static int backTrack(TreeNode root) {
        dfs(root);
        return res;
    }

    public static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        track.add(root.val);
        trackSum += root.val;
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        // 叶子节点
        if (l == null && r == null) {
            int temp = track.size() - trackSum;
            if (trackSum - temp == 1) {
                res++;
            }
        }
        track.removeLast();
        trackSum -= root.val;
        return root;
    }
}
