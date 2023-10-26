package org.algorithm.tree.postorder_4;

import org.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/18 08:48
 * @Description: <p>
 * 寻找重复的子树
 */
public class FindDuplicateSubtrees {
    // 记录所有子树以及出现的次数
    public HashMap<String, Integer> map = new HashMap<>();
    // 记录重复的子树根节点
    public LinkedList<TreeNode> res = new LinkedList<>();


    /**
     * 1.记录每个子树的序列化结果（String）
     * 2.统计子树序列化结果的出现次数（有重复的）
     * 3.找出重复子树
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    // 定义：输入以 root 为根的二叉树，返回这棵树的序列化字符串
    public String serialize(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = serialize(root.left);
        String right = serialize(root.right);
        /* 后序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String myself = left + "," + right + "," + root.val;
        int freq = map.getOrDefault(myself, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        map.put(myself, freq + 1);
        return myself;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{
                1,
                2, 3,
                4, 0, 2, 4,
                0, 0, 0, 0, 4, 0, 0, 0
        };
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
    }
}
