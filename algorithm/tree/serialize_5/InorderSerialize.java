package org.algorithm.tree.serialize_5;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/18 10:23
 * @Description: <p>
 * 二叉树的序列化
 * 中序遍历解法
 * 序列化方法 serialize
 * 反序列化方法  实现不了
 */
public class InorderSerialize {
    // 代表分隔符的字符
    private String SEP = ",";
    // 代表 null 空指针的字符
    private String NULL = "#";
    // 用于拼接字符串
    private StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        inSerialize(root);
        return sb.toString();
    }

    /**
     * 序列化
     * 将二叉树打平为字符串
     */
    public void inSerialize(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        inSerialize(root.left);
        // 中序位置
        sb.append(root.val).append(SEP);
        inSerialize(root.right);
    }

}
