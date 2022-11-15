package java.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * Example 1:
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * 
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 */

public class BinaryTreePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new LinkedList<>();
        recPreorder(root, preorder);
        return preorder;
    }

    private void recPreorder(TreeNode node, List<Integer> preorder) {
        if (node != null) {
            preorder.add(node.val);
            recPreorder(node.left, preorder);
            recPreorder(node.right, preorder);
        }
    }
}
