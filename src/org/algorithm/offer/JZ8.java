package org.algorithm.offer;

import org.algorithm.tree.TreeNode;
import org.algorithm.tree.build_3.ArrayToTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/21 14:21
 * @Description: 二叉树的下一个结点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * <p>
 * {8,6,10,5,7,9,11},8
 * 9
 */
public class JZ8 {

    public static List<TreeNode> list = new ArrayList<>();

    /**
     * 找到根节点
     *
     * @param pNode
     * @return
     */
    public static TreeNode GetNext(TreeNode pNode) {
        // 1.找到根节点
        int[] nums = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = ArrayToTree.arrayToTree(nums, 0);

        // 2.保存中序遍历结果
        inorder(root);

        // 3.根据中序遍历结果，匹配pNode的下一个节点
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val == pNode.val) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    // 中序遍历
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root); // 中序遍历结果放入集合
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 10, 5, 7, 9, 11};
        TreeNode node = new TreeNode(6);
        System.out.println(GetNext(node));
    }
}
