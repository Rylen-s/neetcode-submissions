class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        mx = 0
        for i in range(len(nums)):
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
            mx = max(dp[i], mx)

                    
        return mx + 1
