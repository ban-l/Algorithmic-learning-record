package org.algorithm.arr;

import java.util.*;

/**
 * @Auther: Ban
 * @Date: 2023/8/14 09:41
 * @Description: <p>
 */
public class RandomizedSet {
    // 存储元素的值
    List<Integer> nums;
    // 记录每个元素对应在 nums 中的索引
    Map<Integer, Integer> valToIndex;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        // 若 val 已存在，不用再插入
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 若 val 不存在，插入到 nums 尾部，
        // 并记录 val 对应的索引值
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        // 若 val 不存在，不用再删除
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // 先拿到 val 的索引
        int index = valToIndex.get(val);
        // 将最后一个元素对应的索引修改为 index
        valToIndex.put(nums.get(nums.size() - 1), index);
        // 交换 val 和最后一个元素
        Collections.swap(nums, index, nums.size() - 1);
        // 在数组中删除元素 val
        nums.remove(nums.size() - 1);
        // 删除元素 val 对应的索引
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        // 随机获取 nums 中的一个元素
        return nums.get((int) (Math.random() * nums.size()));
    }

    /**
     * private LinkedList<Integer> nums;
     *
     * public RandomizedSet() {
     * nums = new LinkedList<>();
     * }
     *
     * public boolean insert(int val) {
     * if (!nums.contains(val)) {
     * nums.add(val);
     * return true;
     * }
     * return false;
     * }
     *
     * public boolean remove(int val) {
     * if (nums.contains(val)) {
     * int index = nums.indexOf(val);
     * nums.remove(index);
     * return true;
     * }
     * return false;
     * }
     *
     * public int getRandom() {
     *     int i = new Random().nextInt(nums.size());
     *     return nums.get(i);
     * }
     * @return
     */


}
