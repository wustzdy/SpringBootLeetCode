package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//面试题 02.08. 环路检测
//https://zhuanlan.zhihu.com/p/361049436?utm_id=0
public class detectCycle {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);

        node5.next = node3;
        System.out.println(oldLode);

        ListNode resultNode = detectCycle2(oldLode);
        System.out.println(resultNode.val); //3
    }

    private static ListNode detectCycleListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
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


//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder(64);
//            sb.append("[");
//            ListNode p = this;
//            while (p != null) {
//                sb.append(p.val);
//                if (p.next != null) {
//                    sb.append(",");
//                }
//                p = p.next;
//            }
//            sb.append("]");
//            return sb.toString();
//        }
    }
}
