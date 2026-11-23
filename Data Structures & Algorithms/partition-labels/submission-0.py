class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        d = {}
        res = []

        for i,c in enumerate(s):
            d[c] = i
        size = end = 0
        for i, c in enumerate(s):
            size += 1
            end = max(end, d[c])
            if i == end:
                res.append(size)
                size = 0
        return res
        
