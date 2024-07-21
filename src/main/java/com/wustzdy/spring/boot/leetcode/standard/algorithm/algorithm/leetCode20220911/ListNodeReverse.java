package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

import com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode.reverseList;

//单链表反转
/*[1,2,3,4,5]
  链表反转后：
  [5,4,3,2,1]
*/
public class ListNodeReverse {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println("oldNode:" + node1);
        ListNode result = reverseList(node1);
        System.out.println("newNode:" + result);
    }

    private static ListNode reverseList(ListNode oldNode) {
        ListNode newNode = null;
        ListNode p = oldNode;
        while (p != null) {
            newNode = new ListNode(p.val, newNode);
            p = p.next;
        }
        return newNode;
    }

    private static ListNode ListNodeReverseFunction(ListNode oldNode) {
        ListNode newNode = null;
        ListNode p = oldNode;
        while (p != null) {
            newNode = new ListNode(p.val, newNode);
            p = p.next;
        }
        return newNode;
    }

    public ListNode ReverseList1(ListNode head) {
        //        //  思路：用新头结点替换原头节点，并将原头节点后移一位，然后再次循环替换、移位，直至原头结点为空，最后返回新的头节点
        // write code here
        //创建新的头节点
        ListNode newHead = null;
        // 头节点不为空时进行循环
        while (head != null) {
            // 将头结点的下一个节点赋值给临时节点
            ListNode temp = head.next;
            // 头节点指向新的头节点
            head.next = newHead;
            // 头结点赋值给新的头节点
            newHead = head;
            // 临时节点赋值给头结点，完成头结点后移
            head = temp;
        }
        // 返回新的头节点
        return newHead;
    }

    //    https://leetcode.cn/problems/reverse-linked-list/solutions/2361282/206-fan-zhuan-lian-biao-shuang-zhi-zhen-r1jel/
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;//// 暂存后继节点 cur.next
            cur.next = pre;// 修改 next 引用指向
            pre = cur;// pre 暂存 cur
            cur = tmp;// cur 访问下一节点
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
