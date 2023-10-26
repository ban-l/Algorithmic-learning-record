package org.algorithm.tree.thinking_2;

import org.algorithm.tree.TreeNode;


/**
 * @Auther: Ban
 * @Date: 2023/8/16 09:06
 * @Description: <p>
 * 二叉树展开为链表
 */
public class Flatten {

    /**
     * 1.后序遍历，分解问题
     * 先把root左子树 变为 root右子树，
     * 再把原来的右子树 链接到 root的右叶子节点（原来左子树的右叶子节点）
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2.将左子树作为右子树
        root.left = null;
        root.right = left;
        // 3.将原先的右子树接到当前右子树的末端
        // 找到当前root 的 叶子节点（右）
        TreeNode p = root;
        while (p.right != null) { // 若左节点为空，p = root
            p = p.right;
        }
        // 叶子节点（右）和原来的right连接
        p.right = right;
    }


    // 先把root右子树 链接到 root左子树的右叶子节点
    // 再把root左子树 变成 root右子树
    public void flatten2(TreeNode root) {
        // base case
        if (root == null) return;
        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 若左节点非空，嫁接
        if (left != null) {
            // 找到左子树的右叶子节点
            TreeNode p = left;
            while (p.right != null) {
                p = p.right;
            }
            // 右子树嫁接到左子树的右叶子节点
            p.right = right;
            // 左子树变为右子树
            root.right = root.left;
            // 左子树变为null
            root.left = null;
        }
    }


//    // 2.前序遍历，构建一个新的链表,需要额外的空间
//    TreeNode dummy = new TreeNode(-1);
//    TreeNode p = dummy;
//
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        // 前序遍历
//        p.right = new TreeNode(root.val);
//        p = p.right;
//        flatten(root.left);
//        flatten(root.right);
//    }

//    3.借用辅助集合：先前序遍历得到结果 res集合，然后root依次添加 右节点为 res中的元素
//    LinkedList<TreeNode> res = new LinkedList<>();
//
//    public void flatten(TreeNode root) {
//        traverse(root);
//        res.pollFirst();
//        traverse2(root);
//    }
//    public void traverse(TreeNode root) {
//        if (root == null) return;
//        res.add(root);
//        traverse(root.left);
//        traverse(root.right);
//    }
//    public void traverse2(TreeNode root) {
//        if (res.isEmpty()) return;
//        root.left =null;
//        root.right = res.pollFirst();
//        traverse2(root.right);
//    }


}
