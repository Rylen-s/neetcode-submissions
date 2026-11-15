class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0] * (target + 1)
        # 1,1,1
        # 3
        # 2,1
        # 1,2
        dp[0] = 1
        for amt in range(1,target+1):
            for n in range(len(nums)):
                if nums[n] <= amt:
                    dp[amt] += dp[amt-nums[n]]
        return dp[target]

        