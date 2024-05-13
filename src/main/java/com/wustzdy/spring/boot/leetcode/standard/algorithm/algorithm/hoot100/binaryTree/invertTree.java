package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.binaryTree;

//翻转二叉树

/**
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 */

public class invertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = invertTree(root);
        System.out.print("treeNode:" + treeNode);

    }

    public static TreeNode invertTree(TreeNode root) {
        // 递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }
        // 下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        // 递归交换当前节点的 左子树
        invertTree(root.left);
        // 递归交换当前节点的 右子树
        invertTree(root.right);
        // 函数返回时就表示当前这个节点，以及它的左右子树
        // 都已经交换完了
        return root;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
