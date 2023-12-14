package org.algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/12/12 09:51
 * @Description: <p>
 */
public class DiffWaysToCompute_1 {
    private HashMap<String, List<Integer>> memo = new HashMap<>();

    // 定义：计算算式 input 所有可能的运算结果
    public List<Integer> diffWaysToCompute(String input) {
        // 查备忘录，避免重复计算
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 扫描算式 input 中的运算符
            if (c == '+' || c == '-' || c == '*') {
                /****** 分 ******/
                // 按照运算符进行分割，给每个运算符的左、右两部分加括号
                List<Integer> left = diffWaysToCompute(input.substring(0, i)); // 子问题，递归
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length())); // 子问题，递归
                /****** 治 ******/
                // 通过子问题的结果，合成原问题的结果
                for (int x : left) {
                    for (int y : right) {
                        if (c == '+') {
                            res.add(x + y);
                        } else if (c == '-') {
                            res.add(x - y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        // 将结果添加进备忘录
        memo.put(input, res);
        return res;
    }
}
