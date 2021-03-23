package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm;

//https://blog.csdn.net/qq_38574563/article/details/107339396
/*1.将两个有序单链表合并成一个有序单链表
          实现步骤：
        （1）获得head1和head2中数据值较小的节点，并设置为合并后链表的首节点。
        （2）通过循环循环依次获得链表1和链表2中数据较小 的节点，并添加到合并链表的末尾 。
        （3）当步骤2执行完毕，如果某一链表中的首节点不为null,则将该链表首节点及其之后的节点添加到合并后链表的末尾。
 */
public class MergeSingleLinkList1 {
    public static void main(String[] args) {
        //创建两个单链表
        //链表1
        Node node1_4 = new Node(289);
        Node node1_3 = new Node(186, node1_4);
        Node node1_2 = new Node(167, node1_3);
        Node node1_1 = new Node(103, node1_2);
        //链表2
        Node node2_4 = new Node(228);
        Node node2_3 = new Node(147, node2_4);
        Node node2_2 = new Node(134, node2_3);
        Node node2_1 = new Node(67, node2_2);

        //测试合并两个有序单链表
        Node headNode = mergeList(node1_1, node2_1);
        print(headNode);
    }

    /*
      实现单链表的遍历操作
     */
    public static void print(Node headNode) {
        //定义一个临时节点，用于辅助单链表的遍历操作
        Node tempNode = headNode;
        //定义一个循环，用于实现单链表的遍历操作
        while (tempNode != null) {
            //输出tempNode中保存的数据值
            System.out.print(tempNode.data + " ");
            //让tempNode指向它的下一个节点
            tempNode = tempNode.next;

        }
    }

    /*
    实现节点类
     */
    private static class Node {
        /*
        用于保存节点中的数据
         */
        private int data;
        /*
         用于保存下一个节点的地址值
         */
        private Node next;

        /*
        为data做初始化的工作
         */
        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node mergeList(Node head1, Node head2) {
        //1.head1和head2都为null
        if (head1 == null && head2 == null) {
            return null;
        }
        //2.head和head2只有一个为null
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //3.定义headnode和lastnode,分别作为合并后链表的首节点或尾结点
        Node headNode = null, lastNode = null;
        //4.获取head1和head2中数据值较小的节点，并设置为合并后链表的首节点和尾结点。
        if (head1.data > head2.data) {
            headNode = head2;
            lastNode = head2;
            //更新head2的值，让head2指向head2的下一个节点
            head2 = head2.next;
        } else {
            headNode = head1;
            lastNode = head1;
            head1 = head1.next;
        }
        //5.定义一个循环，用于依次的获取链表1和链表2中数据值较小的节点，并把该节点添加到合并后链表的末尾。
        while (head1 != null && head2 != null) {
            //处理head1的数据值大于head2的情况
            if (head1.data > head2.data) {
                lastNode.next = head2;
                lastNode = head2;
                //更新head2的值
                head2 = head2.next;
            } else {
                lastNode.next = head1;
                lastNode = head1;
                head1 = head1.next;

            }
        }
        //6.循环执行完毕，如果某个链表的首节点不为null,那么我们将这个链表的首节点及其之后的节点添加到合并后的链表的末尾
        if (head1 == null) {
            lastNode.next = head2;
        } else {
            lastNode.next = head1;
        }
        //7.返回合并后链表的首节点
        return headNode;
    }
}
