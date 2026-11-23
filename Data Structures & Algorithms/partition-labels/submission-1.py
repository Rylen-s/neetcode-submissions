class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        d = {}
        res = []

        for i,c in enumerate(s):
            d[c] = i
        start = 0
        while start < len(s):
            end = d[s[start]]
            index = start + 1 
            while index < end:
                end = max(end, d[s[index]])
                index += 1
            res.append(end - start + 1)
            start = end + 1
        return res
        
