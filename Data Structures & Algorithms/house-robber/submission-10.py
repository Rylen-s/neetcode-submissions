class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2: return max(nums)
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for n in range(2,len(nums)):
            dp[n] = max(dp[n-1], dp[n-2] + nums[n])
            print(n, dp[n])
        return max(dp)