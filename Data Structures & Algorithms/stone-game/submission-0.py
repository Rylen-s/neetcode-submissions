class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        l, r = 0, len(piles) - 1
        A, B = 0,0
        while l <= r:
            A += max(piles[l], piles[r])
            B += min(piles[l], piles[r])
            l += 1
            r -= 1
        return A > B
