package com.jayne.leetcode;

import cn.hutool.json.JSONUtil;

/**
 * @author bin.chen
 * @create 2023-03-28 4:05 PM
 */
public class L2AddTwoNums {

    public static void main(String[] args) {
        //243 + 564 = 708
        ListNode node1 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node111 = new ListNode(3);
        node1.next = node11;
        node11.next = node111;
        System.out.println(JSONUtil.toJsonPrettyStr(node1));

        ListNode node2 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node222 = new ListNode(4);
        node2.next = node22;
        node22.next = node222;
        System.out.println(JSONUtil.toJsonPrettyStr(node2));

        System.out.println(JSONUtil.toJsonPrettyStr(add(node1, node2)));
    }

    static ListNode add(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode cur = result;
        while (node1 != null || node2 != null || carry != 0) {
            int s = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + carry;
            carry = s / 10;
            ListNode next = new ListNode(s % 10);
            cur.next = next;
            cur = cur.next;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        return result.next;
    }
}
