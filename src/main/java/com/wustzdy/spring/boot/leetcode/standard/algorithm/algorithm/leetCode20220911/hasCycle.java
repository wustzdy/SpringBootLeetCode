package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//判断链表是否有环
public class hasCycle {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(-4, null);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(3, node2);
        node4.next = node2;
        System.out.println(oldLode);

        boolean result = hasCycle(oldLode);
        System.out.println(result);
    }

    public static boolean hasCycle(ListNode head) {// 3 2 0 -4 2
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }


        /*@Override
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[");
            ListNode p = this;
            while (p != null) {
                sb.append(p.val);
                if (p.next != null) {
                    sb.append(",");
                }
                p = p.next;
            }
            sb.append("]");
            return sb.toString();
        }*/
    }
}
