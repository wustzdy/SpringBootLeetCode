package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;


//JZ25 合并两个排序的链表
public class MergeListNode {
    public static void main(String[] args) {
        //1，创建两个单链表
        //链表1：
//        ListNode node1_4 = new ListNode(6);
//        ListNode node1_3 = new ListNode(5, node1_4);
        ListNode node1_2 = new ListNode(3, null);
        ListNode node1_1 = new ListNode(1, node1_2);

        //链表2：
//        ListNode node2_4 = new ListNode(8);
//        ListNode node2_3 = new ListNode(7, node2_4);
        ListNode node2_2 = new ListNode(4, null);
        ListNode node2_1 = new ListNode(2, node2_2);

        System.out.println("链表1:" + node1_1);
        System.out.println("链表2:" + node2_1);
        ListNode resultListNode = mergeListNode1(node1_1, node2_1);
        System.out.println("合并后的链表为:" + resultListNode);
    }

    private static ListNode mergeListNode1(ListNode pHead1, ListNode pHead2) {
        //pHead1:1 3
        //pHead2:2 4
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        if (pHead1 == null) {
            cur.next = pHead2;
        } else {
            cur.next = pHead1;
        }
        return dummy.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        //一个已经为空了，直接返回另一个
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //两个链表都要不为空
        while (list1 != null && list2 != null) {
            //取较小值的节点
            if (list1.val <= list2.val) {
                cur.next = list1;
                //只移动取值的指针
                list1 = list1.next;
            } else {
                cur.next = list2;
                //只移动取值的指针
                list2 = list2.next;
            }
            //指针后移
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if (list1 != null) cur.next = list1;
        else cur.next = list2;
        //返回值去掉表头
        return head.next;
    }

    private static ListNode mergeListNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        if (pHead1.val <= pHead2.val) {
            pHead1.next = mergeListNode(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = mergeListNode(pHead1, pHead2.next);
            return pHead2;
        }
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
