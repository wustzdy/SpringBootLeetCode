package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

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
        ListNode oldLode = new ListNode(1, node2);
        System.out.println(oldLode);

        System.out.println("链表反转后：");
        ListNode newNode = ListNodeReverseFunction(oldLode);
        System.out.println(newNode);
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
}
