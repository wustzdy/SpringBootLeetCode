package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//11,BM16 删除有序链表中重复的元素-II
//给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
//输入：{1,2,2}  返回值：{1}
//输入：{1,2,3,3,4,4,5}  返回值：{1,2,5}

/**
 * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，
 * 就可以删除重复的元素。由于链表的头节点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点。
 * 具体地，我们从指针 cur 指向链表的哑节点，随后开始对链表进行遍历。
 * 如果当前cur.next 与 cur.next.next 对应的元素相同，
 * 那么我们就需要将cur.next 以及所有后面拥有相同元素值的链表节点全部删除。我们记下这个元素值 xxx，
 * 随后不断将 cur.next 从链表中移除，直到cur.next 为空节点或者其元素值不等于 xxx 为止。此时
 * 我们将链表中所有元素值为 xxx 的节点全部删除。
 * 如果当前 cur.next 与 cur.next.next 对应的元素不相同，那么说明链表中只有一个元素值为 cur.next 的节点，
 * 那么我们就可以将cur 指向cur.next。
 * 当遍历完整个链表之后，我们返回链表的的哑节点的下一个节点dummy.next 即可。
 */
public class deletedepulateNode {
    public static void main(String[] args) {
//        ListNode node7 = new ListNode(5, null);
//        ListNode node6 = new ListNode(4, node7);
//        ListNode node5 = new ListNode(4, node6);
//        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println("初始链表:" + oldLode);

        System.out.println("删除重复元素链表之后：");
        ListNode newNode = deleteDuplicatedNode(oldLode);
        System.out.println(newNode);
    }

    private static ListNode deleteDuplicatedNode(ListNode head) {
        //0 1 1 2
        if (head == null) {
            return null;
        }
//        ListNode dummy = new ListNode(0, head);
//        ListNode cur = dummy;

        //和下面三句等价
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur=dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
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
