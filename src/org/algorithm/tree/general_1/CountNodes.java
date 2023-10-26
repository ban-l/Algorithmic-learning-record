package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/9/2 08:52
 * @Description: <p>
 * 完全二叉树的节点个数
 */
public class CountNodes {


    /**
     * 3.利用完全二叉树的性质
     * 由于完全二叉树的性质，其子树
     * --有一棵一定是满二叉树，按照数学公式返回值，不会递归
     * --另一颗可能是满二叉树，也可能是完全二叉树，按照上述逻辑递归
     * <p>
     * 算法的递归深度就是树的高度 O(logN)，每次递归所花费的时间就是 while 循环，需要 O(logN)
     * 所以总体的时间复杂度是 O(logN*logN)
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        // 沿最左侧和最右侧分别计算高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右侧的高度不同，则按照普通二叉树的逻辑计算（左+右+1）
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 1.遍历一遍，维护外部变量
    private int res = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res++;
        traverse(root.left);
        traverse(root.right);
    }

    // 2.动态规划，返回值
    public int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dp(root.left);
        int r = dp(root.right);
        return l + r + 1;
    }
}
