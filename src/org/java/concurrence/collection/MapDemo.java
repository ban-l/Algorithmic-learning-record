package org.java.concurrence.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Ban
 * @Date: 2023/8/8 21:23
 * @Description: <p>
 */
public class MapDemo {
    public static void main(String[] args) {


        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        String key1 = "key1";
        map.put(key1, 1);
        // 原子更新
        // compute方法 提供一个键 和 一个计算新值的函数
        // 这个函数接受 键 和相关联的 值，计算新值（若不存在，为null）
        map.compute(key1, (k, v) -> v == null ? 1 : v + 1);
        System.out.println(map.get(key1));

        String key2 = "key2";
        map.computeIfAbsent(key2, k -> 100); // 若不存在，put键值对
        System.out.println(map.get(key2));

        String key3 = "key3";
        // map.put(key3, 1);
        map.computeIfPresent(key3, (k, v) -> v + 1); // 若不存在，为null
        System.out.println(map.get(key3));

        String key4 = "key4";
        // map.put(key4, 10);
        map.merge(key4, 1, Integer::sum); // 若不存在，为初始值
        System.out.println(map.get(key4));

        /**

         ConcurrentLinkedQueue<Integer> linkedQueue = new ConcurrentLinkedQueue<>();

         ConcurrentSkipListSet<Integer> set1 = new ConcurrentSkipListSet<>();
         ConcurrentSkipListSet<Integer> set2 = new ConcurrentSkipListSet<>((o1, o2) -> o1 - o2);

         ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
         ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>(32);
         ConcurrentHashMap<String, String> map3 = new ConcurrentHashMap<>(32, 1, 1);

         ConcurrentSkipListMap<Integer, Integer> skipListMap1 = new ConcurrentSkipListMap<>();
         ConcurrentSkipListMap<Integer, Integer> skipListMap2 = new ConcurrentSkipListMap<>((o1, o2) -> o1 - o2);
         */
    }
}
