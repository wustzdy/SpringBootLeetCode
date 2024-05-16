package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;

//单链表排序
public class sortListNode {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(2, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println("初始链表:" + oldLode);

        System.out.println("排序之后的链表：");
        ListNode newNode = sortNode(oldLode);
        System.out.println(newNode);
    }

    private static ListNode sortNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表从fast与mid之间断开，切分成head和tmp两部分
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortNode(head);
        ListNode right = sortNode(tmp);

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if (left == null) {
            curr.next = right;
        } else {
            curr.next = left;
        }
        return dummyHead.next;
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
