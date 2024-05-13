package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

public class commonNode {
    public static void main(String[] args) {

        ListNode node1_2 = new ListNode(3, null);
        ListNode node1_1 = new ListNode(1, node1_2);

        ListNode node2_2 = new ListNode(4, null);
        ListNode node2_1 = new ListNode(2, node2_2);

        System.out.println("链表1:" + node1_1);
        System.out.println("链表2:" + node2_1);
        ListNode resultListNode = findCommonNode(node1_1, node2_1);
        System.out.println("合并后的链表为:" + resultListNode);
    }

    private static ListNode findCommonNode(ListNode node11, ListNode node21) {
        return null;
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


        @Override
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
        }
    }
}
