from ast import List
import math


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums)-1

        if target > nums[len(nums)-1]:
            return len(nums)

        if target < nums[start]:
            return start

        while start <= end:
            mid = math.floor((start + end) / 2)

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        return start
