package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//JZ22 链表中倒数最后k个结点
public class KNodeSolution {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println(oldLode);

        ListNode newNode = FindKthToTail(oldLode, 2);
        System.out.println(newNode);
    }

    private static ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = pHead;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < k; i++) {
            if (fast != null && fast.next != null) {
                fast = fast.next;
            } else {
                return slow = null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode FindKthToTail1(ListNode pHead, int k) {
        int n = 0;
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先行k步
        for (int i = 0; i < k; i++) {
            if (fast != null)
                fast = fast.next;
                //达不到k步说明链表过短，没有倒数k
            else
                return slow = null;
        }
        //快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
