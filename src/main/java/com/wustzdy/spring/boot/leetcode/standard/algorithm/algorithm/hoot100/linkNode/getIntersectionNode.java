package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911.FindFirstCommonNode;

import java.util.HashSet;
import java.util.Set;
//BM10 两个链表的第一个公共结点
//输入：1 2 3 6 7
//       4 5 6 7
// 输出：6 7

public class getIntersectionNode {
    public static void main(String[] args) {
        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);
        ListNode node3 = new ListNode(3, node6);
        ListNode node2 = new ListNode(2, node3);
        ListNode pHead1 = new ListNode(1, node2);


        ListNode node4 = new ListNode(5, node6);
        ListNode pHead2 = new ListNode(4, node4);

        ListNode oldNode = getIntersectionNode(pHead1, pHead2);
        System.out.println("oldNode:" + oldNode);

    }

    //standard
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //pHead1：1 2 3 6 7
        //pHead2：  4 5 6 7
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;//6 7
    }

    private static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //pHead1：1 2 3 6 7
        //pHead2：  4 5 6 7
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {///直到找到公共节点
            if (node1 == null) {
                node1 = pHead2;
            } else {
                node1 = node1.next;
            }

            if (node2 == null) {
                node2 = pHead1;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
        // 当 node2: 1 2 3 6 7
        //    node1为null,
    }

    ////思路为：
    ////1、先算出两个链表的长度
    ////2、然后计算出差值，让长链表先走差值的步数
    ////3、两链表再一起走直到遇到相同的节点，则此节点为重合部分的入口节点
    private static ListNode findFirstCommonNode1(ListNode pHead1,
                                                 ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //2、计算链表的长度
        int lenA = 0;
        int lenB = 0;

        ListNode curA = pHead1;
        ListNode curB = pHead2;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = pHead1;
        curB = pHead2;

        int len = lenA - lenB;
        if (len > 0) {
            while (len-- > 0) {
                curA = curA.next;
            }
        } else {
            len = -len;
            while (len-- > 0) {
                curB = curB.next;
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
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
