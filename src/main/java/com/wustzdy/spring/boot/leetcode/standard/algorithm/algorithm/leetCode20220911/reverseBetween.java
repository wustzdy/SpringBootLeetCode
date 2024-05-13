package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220911;

//BM2 链表内指定区间反转
public class reverseBetween {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode oldLode = new ListNode(1, node2);
        System.out.println(oldLode);

        System.out.println("BM2 链表内指定区间反转节点为：");
        ListNode newNode = reverseBetween(oldLode, 2, 4);

        System.out.println(newNode);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //1 2 3 4 5
        //1 4 3 2 5

        // 用于指向头结点，在完成反转后返回，防止头节点丢失
        ListNode dummy = new ListNode(-1);
        // next指向头节点
        dummy.next = head;
        ListNode pre = dummy;
        // 将pre移至m节点的前一个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 指向m节点
        ListNode cur = pre.next;
        // 初始化cur节点的下一节点
        ListNode temp = null;
        // 进行n-m次反转,反转过程中，cur节点一直不变，因为cur节点最终会位于反转链的末尾，
        // 每一次循环都完成一次将原cur链中cur节点的下一节点放至反转链的头节点位置，并与pre节点拼接的过程
        for (int i = 0; i < (n - m); i++) {
            temp = cur.next;
            //cur节点指向它的下下节点,即删除pre链和cur链中的temp节点(cur的下一个节点)
            cur.next = temp.next;
            // 使temp节点指向pre节点的下一节点，即在pre节点的一下节点前拼接temp节点
            temp.next = pre.next;
            // 在pre节点后拼接temp链
            pre.next = temp;
        }
        // 如果从第一个节点开始反转，此时pre = dummy，则pre.next = temp即为dummy.next = temp，首节点会变化
        // 如果不是从第一个节点开始反转，则pre != dummy,则dummy.next =  head，而head在反转过程中未发生变化，首节点不变化
        // 这保证了dummy一直指向头结点，因此不返回head或者pre，而是返回dummy.next
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
