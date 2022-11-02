"""
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]
"""
from ast import List


class Solution:
    def helper(self, nums, temp, ans):
        if len(nums) == 0:
            ans.append(temp)
            return

        for i in range(len(nums)):
            self.helper(nums[:i]+nums[i+1:], temp+[nums[i]], ans)

    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.helper(nums, [], ans)
        return ans
