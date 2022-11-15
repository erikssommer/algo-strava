package java.easy;

/**
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]
 */

import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        recInorder(root, inorder);
        return inorder;
    }

    private void recInorder(TreeNode node, List<Integer> inorder) {
        if (node != null) {
            recInorder(node.left, inorder);
            inorder.add(node.val);
            recInorder(node.right, inorder);
        }
    }
}