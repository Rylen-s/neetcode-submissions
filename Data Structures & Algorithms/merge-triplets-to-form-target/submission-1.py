class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        d = defaultdict(int)
        for i in range(len(target)):
            d[i] = target[i]
        s = set()
        
        for triplet in triplets:
            res = []
            for i in range(len(triplet)):
                if triplet[i] > d[i]:
                    res = []
                    break
                if triplet[i] == d[i]:
                    res.append(i)
            for n in res:
                s.add(n)
        
        if len(s) == 3:
            return True

        return False


