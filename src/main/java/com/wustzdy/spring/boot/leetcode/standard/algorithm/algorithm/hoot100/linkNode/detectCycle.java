package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;

//https://zhuanlan.zhihu.com/p/361049436?utm_id=0

// 返回链表开始入环的第一个节点
//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
// 1,和链表中环的入口节点-一个意思
//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
//输入：{1,2},{3,4,5}
//返回值：3
//说明：返回环形链表入口结点，我们后台程序会打印该环形链表入口结点对应的结点值，即3
// 输入：head = [3,2,0,-4], pos = 1
// 输出：返回索引为 1 的链表节点
// 解释：链表中有一个环，其尾部连接到第二个节点。
public class detectCycle {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);

        node5.next = node3;
        System.out.println(oldLode);//1 2 3 4 5 3

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
