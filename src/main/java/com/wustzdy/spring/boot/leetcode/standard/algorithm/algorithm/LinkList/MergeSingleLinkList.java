package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

/**
 * 合并两个有序的单链表
 * 链表1：1--->3--->5--->6
 * 链表2：2---->4--->7--->8
 * 合并之后的链表：1--->2--->3--->4---->5---->6---->7--->8
 */
public class MergeSingleLinkList {
    public static void main(String[] args) {
        //1，创建两个单链表
        //链表1：
        Node node1_4 = new Node(6);
        Node node1_3 = new Node(5, node1_4);
        Node node1_2 = new Node(3, node1_3);
        Node node1_1 = new Node(1, node1_2);

        //链表2：
        Node node2_4 = new Node(8);
        Node node2_3 = new Node(7, node2_4);
        Node node2_2 = new Node(4, node2_3);
        Node node2_1 = new Node(2, node2_2);

        //2,合并两个有序的单链表
        Node headNode = mergeList(node1_1, node2_1);
        print(headNode);
    }

    public static void print(Node headNode) {
        //1,定义一个临时节点，用于辅助单链表的遍历操作
        Node tempNode = headNode;
        while (tempNode != null) {
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        }
    }

    /***
     *mergeList：合并两个有序的单链表
     * head1：链表1的首节点
     * head2：链表2的首节点
     * return：返回合并后链表的首节点
     */

    public static Node mergeList(Node head1, Node head2) {
        //1，处理Head1，head2都为null的情况
        if (head1 == null && head2 == null) {
            return null;
        }
        //2,处理head1 和head2其中有一个为null的情况
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //3,定义headNode 和lastNode ，分别作为合并后链表的首节点和尾节点
        Node headNode = null, lastNode = null;
        //4,获取head1和head2中数据值较小的节点，并设置为合并后链表的首节点和尾节点
        if (head1.data > head2.data) {
            headNode = head2;
            lastNode = head2;
            //更新head2的值，让head2指向它的下一个节点
            head2 = head2.next;
        } else {
            headNode = head1;
            lastNode = head1;
            //更新head2的值，让head2指向它的下一个节点
            head1 = head1.next;
        }
        //5,定一个循环，用于依次的获取链表1和链表2中数据值较小的节点，并把该节点添加到合并后链表的末尾
        while (head1 != null & head2 != null) {
            //处理head1的数据值大于head2的情况
            if (head1.data > head2.data) {
                lastNode.next = head2;
                lastNode = head2;
                //更新head2的值，让head2指向它的下一个节点
                head2 = head2.next;
            } else {
                lastNode.next = head1;
                lastNode = head1;
                //更新head1的值，让head1指向它的下一个节点
                head1 = head1.next;
            }
        }
        //6,循环执行完毕，如果某个链表的首节点不为null，那么我们就将这个链表的首节点及其之后的的节点添加到合并后链表的尾部
        if (head1 == null) {//意味着head2不为null
            lastNode.next = head2;
        } else {//意味着head1不为null
            lastNode.next = head1;
        }
        //7，返回合并后链表的首节点
        return headNode;
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
