class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        pq = []
        for i, t in enumerate(tasks):
            t.append(i)
        tasks.sort(key=lambda t: t[0])

        res = []
        i , time = 0, tasks[0][0]

        while pq or i < len(tasks):
            while i < len(tasks) and time >= tasks[i][0]:
                heapq.heappush(pq, [tasks[i][1], tasks[i][2]])
                i += 1
            if not pq:
                time = tasks[i][0]
            else:
                proc, index = heapq.heappop(pq)
                time += proc
                res.append(index)
        return res



    