package org.algorithm.tree.serialize_5;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/18 10:07
 * @Description: <p>
 * 二叉树的序列化与反序列化
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }


    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    public static void main(String[] args) {
        int[] arr = new int[]{
                1,
                2, 3,
                0, 4, 0, 0
        };
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans.toString());
    }
}