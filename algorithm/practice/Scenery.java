package org.algorithm.practice;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/10/12 18:32
 * @Description: <p>
 * <p>
 * 某游戏的地图可以用 N行 M列 的格子表示
 * 如果是墙，我们会记为#
 * 如果是空地，我们会标记为.
 * 如果一个空地在4个方向看都能看到地图边界之外，那么该空地可以被称之为「景观位]
 * <p>
 * 其中 * 所在处就是[景观位]
 * 传入地图(一个有N个元素的字符串数组，每个字符串的长度是M)，返回[景观位]的数量
 * 举个例子，6行9列的地图如下：
 * ..#......
 * .........
 * .###..#..
 * .#.##..#.
 * ...#..#..
 * .........
 * [景观位]有6个
 * <p>
 * 请使用JavaScript语言实现上述问题
 * <p>
 * ..#......
 * *....*..*
 * .###..#..
 * .#.##..#.
 * ...#..#..
 * *....*..*
 */
public class Scenery {

    public static int solution(String[] nums) {
        int m = nums.length;
        int n = nums[0].length();
        // 整列的值 存储在 HashMap(列索引，整列值)
        HashMap<Integer, String> colum = new HashMap();
        for (int j = 0; j < n; j++) { // 列
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) { // 行
                sb.append(nums[i].charAt(j));
            }
            colum.put(j, sb.toString());
        }
        int count = 0; // 记录结果
        for (int i = 0; i < m; i++) { // 行
            if (nums[i].indexOf("#") != -1) { // 行含有#进行下一次循环
                continue;
            }
            for (int j = 0; j < n; j++) { // 列
                if (colum.get(j).indexOf("#") != -1) { // 列含有#进行下一次循环
                    continue;
                }
                // 存在，+1
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] nums = {
                "..#......",
                ".........",
                ".###..#..",
                ".#.##..#.",
                "...#..#..",
                "........."
        };
        System.out.println(solution(nums));
    }
}
