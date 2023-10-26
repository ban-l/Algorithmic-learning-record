package org.algorithm.tree.serialize_5;

import org.algorithm.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/8/18 10:22
 * @Description: <p>
 * 二叉树的序列化与反序列化
 * 前序遍历解法
 */
public class PreorderSerialize_1 {

    // 代表分隔符的字符
    private String SEP = ",";
    // 代表 null 空指针的字符
    private String NULL = "#";
    // 用于拼接字符串
    private StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preSerialize(root);
        return sb.toString();
    }

    /**
     * 序列化
     * 将二叉树打平为字符串
     */
    public void preSerialize(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序位置
        sb.append(root.val).append(SEP);
        preSerialize(root.left);
        preSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        // 字符串转为集合
        Collections.addAll(nodes, data.split(SEP));
        return preDeserialize(nodes);
    }

    /**
     * 反序列化
     * 有空指针，前序和后序可以还原出唯一的一棵二叉树
     * 先确定根节点 root，然后遵循前序遍历的规则，递归生成左右子树即可
     */
    public TreeNode preDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        /****** 前序位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(Integer.valueOf(first));
        // 递归构建左右子树
        root.left = preDeserialize(nodes);
        root.right = preDeserialize(nodes);
        return root;
    }
}
