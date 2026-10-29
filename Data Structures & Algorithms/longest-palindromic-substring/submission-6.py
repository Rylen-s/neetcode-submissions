class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        resLen, resIdx = 0,0
        dp = [[False] * n for _ in range(n)]

        for j in range(n-1, -1, -1):
            for i in range(j,n):
                if s[i] == s[j] and (i - j <= 2 or dp[j+1][i-1]):
                    dp[j][i] = True

                    if i - j + 1 > resLen:
                        resIdx = j
                        resLen = i - j + 1
        return s[resIdx : resIdx + resLen]
            

             
