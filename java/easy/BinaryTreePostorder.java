package java.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 * 
 * Example 1:
 * 
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * 
 */

public class BinaryTreePostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new LinkedList<>();
        recPostorder(root, postorder);
        return postorder;
    }

    private void recPostorder(TreeNode node, List<Integer> postorder) {
        if (node != null) {
            recPostorder(node.left, postorder);
            recPostorder(node.right, postorder);
            postorder.add(node.val);
        }
    }
}
