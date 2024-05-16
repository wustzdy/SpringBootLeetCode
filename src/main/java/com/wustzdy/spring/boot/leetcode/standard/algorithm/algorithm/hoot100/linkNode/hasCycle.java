package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;


//2， 判断链表中是否有环(环路检测)
//输入：输入：{3,2,0,-4},1
//返回值：true
//说明：第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1（注：头结点为位置0），即-4->2存在一个链接，组成传入的head为一个带环的链表，返回true
/**
 * 我们使用快慢指针的方法来判断链表是否有环。我们让一个指针slow每次移动一步，另一个指针fast每次移动两步，如果链表有环，
 那么fast指针最终会追上slow指针，从而形成一个循环。如果fast指针走到了链表的末尾，那么说明链表没有环。
 */
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
