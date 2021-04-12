package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.LinkList;

//https://www.bilibili.com/video/BV1Wa4y1Y7ji/?spm_id_from=333.788.recommend_more_video.1
//https://www.bilibili.com/video/BV13v411B74n
//https://haokan.baidu.com/v?vid=8105262896543583302&pd=bjh&fr=bjhauthor&type=video
//单链表的反转
public class ReverseLinklist {
    public static void main(String[] args) {
        // 创建一个单链表
        Node lastNode = new Node(44);
//        Node node3 = new Node(33, lastNode);
//        Node node2 = new Node(22, node3);
        Node headNode = new Node(11, lastNode);
        print(headNode);
        System.out.println("-------");
        Node reverse = reverseLinkedList(headNode);
        print(reverse);

    }

    public static void print(Node headNode) {
        //1,定义一个临时节点，用于辅助单链表的遍历操作
        Node tempNode = headNode;
        while (tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNext();
        }
        return;

    }

    /***
     *
     * */
    public static Node reverseLinkedList(Node headNode) {
        //1,判段headNode 为null和单链表只有一个节点的情况
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        //2,定义一个节点用于保存反转后链表的首节点
        Node reverse = null;
        //3,定义一个循环，用于实现单链表的反转操作
        while (headNode != null) {
            //4,获得HeadNode 的下一个节点
            Node nodeNext = headNode.getNext();
            //5,把hheadNode插入到反转后链表的最前面
            headNode.setNext(reverse);
            //6,更新需要反转后链表的首节点
            reverse = headNode;
            //7,更新需要反转链表的首节点
            headNode = nodeNext;
            //
        }
        //8,返回愿链表的首节点
        return reverse;

    }

    public static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Object getData() {
            return data;
        }
    }
}
