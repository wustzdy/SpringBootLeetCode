package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//JZ22 链表中倒数最后k个结点
//  输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。如果该链表长度小于k，请返回一个长度为 0 的链表。
//元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
// 输入：{1,2,3,4,5},2
// 输出：{4,5} // 解释：返回倒数第2个节点4，系统会打印后面所有的节点来比较。
/** 思路：
 我们无法逆序遍历链表，就很难得到链表的倒数第kkk个元素，那我们可以试试反过来考虑，如果当前我们处于倒数第kkk的位置上，即距离链表尾的距离是kkk，
 那我们假设双指针指向这两个位置，二者同步向前移动，当前面个指针到了链表头的时候，两个指针之间的距离还是kkk。虽然我们没有办法让指针逆向移动，但是我们刚刚这个思路却可以正向实施。
 具体做法：step 1：准备一个快指针，从链表头开始，在链表上先走kkk步。
 step 2：准备慢指针指向原始链表头，代表当前元素，则慢指针与快指针之间的距离一直都是kkk。
 step 3：快慢指针同步移动，当快指针到达链表尾部的时候，慢指针正好到了倒数kkk个元素的位置。
 */
public class KNodeSolution {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println(oldLode);

        ListNode newNode = FindKthToTail(oldLode, 2);
        System.out.println(newNode);
    }

    private static ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = pHead;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < k; i++) {
            if (fast != null && fast.next != null) {
                fast = fast.next;
            } else {
                return slow = null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
    public static ListNode FindKthToTail1(ListNode pHead, int k) {
        int n = 0;
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先行k步
        for (int i = 0; i < k; i++) {
            if (fast != null)
                fast = fast.next;
                //达不到k步说明链表过短，没有倒数k
            else
                return slow = null;
        }
        //快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
