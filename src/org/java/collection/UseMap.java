package org.java.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: Ban
 * @Date: 2023/3/27 10:38
 * @Description: Map的基本用法
 */
public class UseMap {
    public static void use() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(3, 115);
        map.size();

        // 输出map的键
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 输出map的值
        Collection<Integer> collection = map.values();
        for (Integer i : collection) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 输出map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // forEach输出map
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        map.forEach((k, v) ->{
            System.out.println(k);
            System.out.println(v);
                }
        );
    }

    public static void main(String[] args) {
        use();
    }
}
