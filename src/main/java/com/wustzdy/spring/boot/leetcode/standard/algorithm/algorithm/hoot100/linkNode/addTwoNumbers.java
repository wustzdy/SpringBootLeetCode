package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.linkNode;

/*
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

假设我们有两个链表，第一个链表是2 -> 4 -> 3，第二个链表是5 -> 6 -> 4。这两个链表表示的数字分别是342和465。
        我们调用addTwoNumbers(l1, l2)，其中l1是第一个链表的头节点，l2是第二个链表的头节点。

        所以，addTwoNumbers(l1, l2)的返回值是链表7 -> 0 -> 8，表示的数字是807。这就是342 + 465 = 807。
 */
public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1node3 = new ListNode(3, null);
        ListNode l1node2 = new ListNode(4, l1node3);
        ListNode l1 = new ListNode(2, l1node2);

        ListNode l2node3 = new ListNode(4, null);
        ListNode l2node2 = new ListNode(6, l2node3);
        ListNode l2 = new ListNode(5, l2node2);

        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("listNode:" + listNode);


    }
    //   2 4 3
    //   5 6 4
    // ->7 0 8
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0); // 创建一个新的链表，pre是其虚拟头节点
        ListNode cur = pre; // 创建一个指针cur，指向当前处理的节点
        int carry = 0; // carry表示进位
        while (l1 != null || l2 != null) { // 当l1或l2不为空时，进入循环
            int x = l1 == null ? 0 : l1.val; // 如果l1不为空，取l1的值，否则取0
            int y = l2 == null ? 0 : l2.val; // 如果l2不为空，取l2的值，否则取0
            int sum = x + y + carry; // 计算当前位的和

            carry = sum / 10; // 更新进位
            sum = sum % 10; // 计算当前位的值
            cur.next = new ListNode(sum); // 创建一个新的节点，值为sum，然后将cur的next指向这个新节点

            cur = cur.next; // 将cur向后移动一位
            if (l1 != null)
                l1 = l1.next; // 如果l1不为空，将l1向后移动一位
            if (l2 != null)
                l2 = l2.next; // 如果l2不为空，将l2向后移动一位
        }
        //**在进行加法运算时，如果最后一位的和大于等于10，那么会产生一个进位。例如，77 + 25，最后一位2和7相加得到9，没有进位，但是第二位7和7相加得到14，产生一个进位1。这个进位需要加到结果的最前面，得到102。
        if (carry == 1) { // 如果最后还有进位
            cur.next = new ListNode(carry); // 创建一个新的节点，值为carry，然后将cur的next指向这个新节点
        }
        return pre.next; // 返回结果链表的头节点
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
/*假设我们有两个链表，第一个链表是2 -> 4 -> 3，第二个链表是5 -> 6 -> 4。这两个链表表示的数字分别是342和465。

我们调用addTwoNumbers(l1, l2)，其中l1是第一个链表的头节点，l2是第二个链表的头节点。

我们创建一个新的链表，pre是其虚拟头节点，cur是当前处理的节点。carry表示进位，初始值为0。
我们进入while循环。在第一次循环中，l1和l2都不为空，所以x等于2，y等于5。我们计算sum = x + y + carry = 2 + 5 + 0 = 7。然后，我们更新carry = sum / 10 = 0，并计算sum = sum % 10 = 7。我们创建一个新的节点，值为7，然后将cur.next指向这个新节点。然后，我们将cur、l1和l2都向后移动一位。
在第二次循环中，x等于4，y等于6。我们计算sum = x + y + carry = 4 + 6 + 0 = 10。然后，我们更新carry = sum / 10 = 1，并计算sum = sum % 10 = 0。我们创建一个新的节点，值为0，然后将cur.next指向这个新节点。然后，我们将cur、l1和l2都向后移动一位。
在第三次循环中，x等于3，y等于4。我们计算sum = x + y + carry = 3 + 4 + 1 = 8。然后，我们更新carry = sum / 10 = 0，并计算sum = sum % 10 = 8。我们创建一个新的节点，值为8，然后将cur.next指向这个新节点。然后，我们将cur、l1和l2都向后移动一位。
此时，l1和l2都为空，所以我们退出while循环。carry等于0，所以我们不需要添加新的节点。
最后，我们返回pre.next，也就是结果链表的头节点。
所以，addTwoNumbers(l1, l2)的返回值是链表7 -> 0 -> 8，表示的数字是807。这就是342 + 465 = 807。
*/
