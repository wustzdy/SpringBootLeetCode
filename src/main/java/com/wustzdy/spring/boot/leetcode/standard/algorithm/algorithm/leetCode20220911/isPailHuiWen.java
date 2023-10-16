package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

public class isPailHuiWen {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(1, null);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println(oldLode);

        System.out.println("链表反转后：");
        /*boolean flag = isPail(oldLode);
        System.out.println(flag);*/

        ListNode mid = findMid(oldLode);
        ListNode l1 = oldLode, l2 = mid;
        l2 = reverseList(l2);
        boolean flag = isSame(l1, l2);
        System.out.println(flag);

      /*  boolean flag = isPalindrome(oldLode);
        System.out.println(flag);*/
    }

    /**
     * 1.找到链表的中间节点
     * 2.原地反转后半部分链表
     * 3.比较前半部分和后半部分链表是否相同
     */
    public static boolean isPail(ListNode head) {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reserve(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return true;
    }

    public static ListNode reserve(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static class ListNode {
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

    private static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private static boolean isSame(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
//我们使用快慢指针 ，fast一次走两步，slow一次走一步。当fast到达表尾的时候，slow正好到达一半的位置，
// 那么接下来可以从头开始逆序一半的元素，或者从slow开始逆序一半的元素，都可以。
    public static boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到中间节点或者前半部分链表的尾节点（注意判断条件）
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分链表
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
