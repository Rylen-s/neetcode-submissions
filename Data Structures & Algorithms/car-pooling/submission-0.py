class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        count = 0
        heap = []

        for ppl, start, end in trips:
            heapq.heappush(heap,[start,ppl])
            heapq.heappush(heap,[end,-ppl])

        while heap:
            temp = heapq.heappop(heap)
            count += temp[1]

            while heap and heap[-1] == temp[0]:
                extra = heapq.heappop(heap)
                count += extra[1]
            
            if count > capacity: return False

        return True