package com.jayne.leetcode;

public class L19RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        int n = 1;
//        System.out.println(removeNthFromEnd(head, n));

        ListNode n2 = new ListNode(2, null);
        head.next = n2;
//        System.out.println(removeNthFromEnd(head, n));

        for (int index = 3; index <= 5; index++) {
            ListNode tmp = new ListNode(index, null);
            n2.next = tmp;
            n2 = tmp;
        }
        System.out.println(head);
        System.out.println(removeNthFromEnd(head, 2));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
