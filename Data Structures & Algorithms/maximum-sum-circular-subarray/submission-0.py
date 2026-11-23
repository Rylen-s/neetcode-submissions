class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        locmin, locmax = 0,0
        globmin, globmax = nums[0],nums[0]
        tot = 0
        for num in nums:
            locmin = min(num, locmin + num)
            locmax = max(num, locmax + num)
            globmin= min(globmin, locmin)
            globmax = max(globmax, locmax)
            tot += num
        return max(globmax, tot - globmin) if globmax > 0 else globmax