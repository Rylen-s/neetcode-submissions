class Solution:
    def numSquares(self, n: int) -> int:
        lim = self.findLim(n)
        if lim == 0:
            return 1

        dp = [sys.maxsize] * (n+1)
        dp[0] = 0

        coins = []
        for num in range(1, lim):
            coins.append(num*num)

        print(coins)

        for num in range(1,n+1):
            for coin in coins:
                if(num - coin >= 0):
                    dp[num] = min(dp[num], dp[num-coin] + 1)
        return dp[n]


    def findLim(self, n: int) -> int:
        for i in range(1,101):
            if i*i == n:
                return 0
            elif i*i > n:
                return i
        return -1    