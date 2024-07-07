package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.binaryTree;
//二叉树公共祖先

import com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.hoot100.binaryTree.node.TreeNode;

/***
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出：3
 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 输出：5
 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class lowestCommonAncestor {
    public static TreeNode ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left=new TreeNode(5);
        root.right=new TreeNode(1);

        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);

        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);

        TreeNode treeNode = lowestCommonAncestor(root, root.left, root.right);
        System.out.print("treeNode:"+treeNode);

    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
