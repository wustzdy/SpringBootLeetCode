package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//单链表反转
public class ListNodeReverse {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println("oldNode:" + node1);
        ListNode result = new ListNodeReverse().revereListNode(node1);
        System.out.println("newNode:" + result);
    }

    private ListNode revereListNode(ListNode oldNode) {
        ListNode newNode = null;
        ListNode p = oldNode;
        while (p != null) {
            newNode = new ListNode(p.val, newNode);//头插法
            p = p.next;
        }
        return newNode;
    }

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
