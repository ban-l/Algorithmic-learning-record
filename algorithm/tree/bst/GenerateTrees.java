package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/31 11:12
 * @Description: <p>
 * 不同的二叉搜索树 II
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        build(1, n);
        return null;
    }

    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
