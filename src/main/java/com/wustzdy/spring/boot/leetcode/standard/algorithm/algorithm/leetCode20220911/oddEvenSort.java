package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//链表的奇偶重排
public class oddEvenSort {
    public static void main(String[] args) {
//        ListNode node5 = new ListNode(9, null);
//        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println("初始链表:" + oldLode);

        System.out.println("奇偶排序元素链表之后：");
        ListNode newNode = oddEvenList(oldLode);
        System.out.println(newNode);
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
