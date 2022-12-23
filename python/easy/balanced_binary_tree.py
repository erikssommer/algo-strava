from typing import Optional

""" 
Given a binary tree, determine if it is 
height-balanced

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true
"""

# Definition for a binary tree node
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        def _isBalanced(node):
            if node is None:
                return 0

            leftHeight = _isBalanced(node.left)
            rightHeight = _isBalanced(node.right)

            if leftHeight is False or rightHeight is False:
                return False

            if abs(leftHeight - rightHeight) > 1:
                return False

            return 1 + max(leftHeight, rightHeight)

        return _isBalanced(root)
