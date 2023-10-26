package org.algorithm.tree.build_3;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/16 11:12
 * @Description: <p>
 * 根据数组创建二叉树
 */
public class ArrayToTree {
    /**
     * 顺序存储创建二叉树
     *
     * @param array
     * @param index
     * @return
     */
    public static TreeNode arrayToTree(int[] array, int index) {
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
        treeNode.left = arrayToTree(array, 2 * index + 1);
        // 右子树
        treeNode.right = arrayToTree(array, 2 * index + 2);
        return treeNode;
    }
}
