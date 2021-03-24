package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

public class ReverseSingleLinkList {
    public static void main(String[] args) {
        //1.创建一个单链表
        Node lastNode = new Node(44);
        Node node3 = new Node(33, lastNode);
        Node node2 = new Node(22, node3);
        Node headNode = new Node(11, node2);
        System.out.println("反转之前的链表");
        print(headNode);

        System.out.println();

        Node reverse = reverseLinkList(headNode);
        System.out.println("反转之后的链表");

        print(reverse);
    }

    /*
      实现单链表的反转
     */
    public static Node reverseLinkList(Node headNode) {
        //1.判断headNode为Null和单链表只有一个节点的情况
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        //2.定义一个节点,用于保存反转后链表的首节点
        Node reverse = null;
        //3.定义一个循环，用于实现单链表的反转操作
        while (headNode != null) {
            //4.获得HeadNode的下一个节点
            Node nextNode = headNode.getNext();
            //5.把headNode插入到反转后链表的最前面
            headNode.setNext(reverse);
            //6.更新反转后链表的首节点
            reverse = headNode;
            //7.跟新需要反转链表的首节点
            headNode = nextNode;
        }
        //8.返回反转后链表的首节点
        return reverse;

    }

    /*实现单链表的遍历操作
     */
    public static void print(Node headNode) {
        //1.定义一个临时节点，用于辅助单链表的便利操作
        Node tempNode = headNode;
        //2.定义一个循环，用于实现单链表的遍历操作
        while (tempNode != null) {
            //3.输出tempNode中保存的数据值
            System.out.print(tempNode.getData() + " ");
            //4.让它的tempNode指向他的下一个节点
            tempNode = tempNode.getNext();
        }

    }

    public static class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getNext() {
            return next;
        }
        public void setData(int data) {
            this.data = data;
        }
        public int getData() {
            return data;
        }
    }
}
