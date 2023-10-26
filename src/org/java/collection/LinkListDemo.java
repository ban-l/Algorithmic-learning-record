package org.java.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Auther: Ban
 * @Date: 2023/6/19 21:09
 * @Description:
 */
public class LinkListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);

        // list.iterator(); // 只可在末尾添加元素
        //  ListIterator 接口 可以在中间添加元素
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next(); // 光标右移
            System.out.println(temp);
            iterator.remove(); // 删除左边元素
            // 左边增加一个元素
            iterator.add(10);
            break;
        }
        System.out.println(list.toString());
        list.forEach(integer -> System.out.println(integer));
    }
}
