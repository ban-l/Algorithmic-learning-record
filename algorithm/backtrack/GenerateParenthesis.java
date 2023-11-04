package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/10/29 09:47
 * @Description: <p>
 * <p>
 * 括号生成
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    // 记录所有合法的路径
    private List<String> res = new ArrayList<>();
    // 回溯过程中的路径
    private StringBuilder track = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        // 可用的左括号、右括号数量初始化为 n
        backTrack(n, n);
        return res;
    }

    // 回溯
    // 通过左括号和右括号的可用数量，进行剪枝
    private void backTrack(int left, int right) {
        // 若可用的左括号剩下的多，说明不合法
        if (left > right) {
            return;
        }
        // 括号小于0 不合法
        if (left < 0 || right < 0) {
            return;
        }
        // base case
        // 所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(String.join("", track));
            return;
        }

        // 一种选择 (
        track.append("(");
        backTrack(left - 1, right);
        track.deleteCharAt(track.length() - 1);  // 撤消选择

        // 另一种选择 )
        track.append(")");
        backTrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);  // 撤消选择
    }
}
