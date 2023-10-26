package org.algorithm.tree.serialize_5;

import org.algorithm.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/8/18 10:23
 * @Description: <p>
 * 二叉树的序列化与反序列化
 * 后序遍历解法
 */
public class PostorderSerialize_2 {
    // 代表分隔符的字符
    private String SEP = ",";
    // 代表 null 空指针的字符
    private String NULL = "#";
    // 用于拼接字符串
    private StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        postSerialize(root);
        return sb.toString();
    }

    /**
     * 序列化
     * 将二叉树打平为字符串
     */
    public void postSerialize(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        postSerialize(root.left);
        postSerialize(root.right);
        // 后序位置
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        // 字符串转为集合
        Collections.addAll(nodes, data.split(SEP));
        return postDeserialize(nodes);
    }

    /**
     * 反序列化
     * 有空指针，前序和后序可以还原出唯一的一棵二叉树
     * 先确定根节点 root，然后遵循前序遍历的规则，递归生成左右子树即可
     */
    public TreeNode postDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 后序遍历，从后往前取出元素，最后一个节点是根节点
        String last = nodes.removeLast();
        if (last.equals(NULL)) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(Integer.valueOf(last));
        // 根节点左侧节点是右子树
        // 递归构建 ，先构造右子树，后构造左子树
        root.right = postDeserialize(nodes);
        root.left = postDeserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        String str = "1,2,#,4,#,#,3,#,#,";
        String[] arr = str.split(",");
        for (String s : arr) {
            System.out.print(s);
        }
    }
}
