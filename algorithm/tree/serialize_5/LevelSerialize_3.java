package org.algorithm.tree.serialize_5;

import org.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Ban
 * @Date: 2023/8/19 09:42
 * @Description: <p>
 */
public class LevelSerialize_3 {
    // 代表分隔符的字符
    private String SEP = ",";
    // 代表 null 空指针的字符
    private String NULL = "#";

    /**
     * 序列化
     * 将二叉树打平为字符串
     */
    public String levelSerialize(TreeNode root) {
        if (root == null) return "";
        // 用于拼接字符串
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 从上到下
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);
                // 队列添加同层节点，空指针也会添加
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    /**
     * 反序列化
     * 字符串反序列化为二叉树结构
     */
    public TreeNode levelDeserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        // 队列 q 记录父节点，将 root 加入队列
        q.offer(root);
        // index 变量记录正在序列化的节点在数组中的位置
        int index = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode parent = q.poll();
                // 为父节点构造 左侧子节点
                String left = nodes[index++];
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.valueOf(left));
                    q.offer(parent.left);
                }
                // 为父节点构造 右侧子节点
                String right = nodes[index++];
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.valueOf(right));
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }
}
