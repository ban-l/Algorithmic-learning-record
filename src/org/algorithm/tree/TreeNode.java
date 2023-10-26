package org.algorithm.tree;

import java.util.Objects;

/**
 * @Auther: ban
 * @Date: 2022/11/7 17:27
 * @Description:二叉树
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 创建二叉树
     * <p>
     * 二叉树的值保存在数组中，数字0表示空节点
     *
     * @param array
     * @param index
     * @return
     */
    public static TreeNode createBinaryTree(int[] array, int index) {
        if (index >= array.length) { // 递归终止条件
            return null;
        }
        if (array[index] == 0) { //值为0，则是空结点
            return null;
        }
        // 前序遍历
        // 生成节点，值为 array[index]
        TreeNode treeNode = new TreeNode(array[index]);
        // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+2
        // 左子树
        treeNode.left = createBinaryTree(array, 2 * index + 1);
        // 右子树
        treeNode.right = createBinaryTree(array, 2 * index + 2);
        return treeNode;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
