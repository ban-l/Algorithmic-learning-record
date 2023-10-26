package org.algorithm;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/10/20 09:28
 * @Description: <p>
 **/
public class Main {
    private static ListNode node;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }
        in.close();
        for (int i = 0; i < n; i++) {
            String[] s = arr[i].split(" ");
            if (s[0].equals("insert")) {
                insert(Integer.valueOf(s[1]), Integer.valueOf(s[2]));
            } else if (s[0].equals("delete")) {
                delete(Integer.valueOf(s[1]));
            }
        }
        print();
    }

    public static void insert(int x, int y) {
        ListNode t = new ListNode();
        t.val = y;
        if (node == null) {
            node = t;
            return;
        }
        ListNode dummy = new ListNode();
        dummy.next = node;
        ListNode pre = dummy;
        while (node != null) {
            if (node.val == x) {
                pre.next = t;
                t.next = node;
                break;
            }
            pre = node;
            node = node.next;
        }
        if (node == null) {
            pre.next = t;
        }
        node = dummy.next;
    }

    public static void delete(int x) {
        ListNode dummy = new ListNode();
        dummy.next = node;
        ListNode pre = dummy;
        while (node != null) {
            if (node.val == x) {
                pre.next = node.next;
                break;
            }
            pre = node;
            node = node.next;
        }
        node = dummy.next;
    }

    public static void print() {
        if (node == null) {
            System.out.println("NULL");
        }
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
