package org.algorithm.dp.steal;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 11:11
 * @Description: <p>
 */
public class Rob_3 {


    /**
     * dp(root) : 以root为根节点，返回抢和不抢的最大值
     * 返回一个大小为 2 的数组 arr，表示不抢与抢的最大值
     * • arr[0] 表示不抢 root ，得到的最大值
     * • arr[1] 表示抢 root ，得到的最大值
     * <p>
     * 状态转移：
     * arr[0]，不抢 root 的话，则左、右子树可以抢、也可以不抢，选择最优即可，即左、右子树最大值相加:
     * • 左子树Max(不抢，抢) + 右子树 Max(不抢，抢)
     * • arr[0] = Math.max(left) + Math.max(right);
     * <p>
     * arr[1]，抢 root 的话，则左、右子树不能抢，选择不抢左、右子树的最大值 加上 当前值:
     * • 当前值 + 左、右子树(不抢最大值)
     * • arr[1] = root.val + left[0] + right[0];
     */
    public static int[] dp(TreeNode root) {
        // base case
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 不抢，则左、右子树可以抢、也可以不抢，选择最优即可
        int no_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢，下家就不能抢了，当前值 + 左、右子树(不抢最大值)
        int rob = root.val + left[0] + right[0];
        return new int[]{no_rob, rob};
    }

    public static int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }
}
