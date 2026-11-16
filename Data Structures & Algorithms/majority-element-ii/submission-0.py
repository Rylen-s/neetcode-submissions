class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        freq = {}
        n = len(nums) / 3
        res = []

        for num in nums:
            freq[num] = freq.get(num,0) + 1
            if freq[num] > n and num not in res:
                res.append(num)

        return res