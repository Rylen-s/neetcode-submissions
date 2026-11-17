class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        directions = [[0,1],[1,0]]
        freq = [[sys.maxsize] * len(grid[0]) for _ in range(len(grid))]
        minheap = []
        freq[0][0] = grid[0][0]
        heapq.heappush(minheap, (grid[0][0],0,0))

        while minheap:
            cost, row, col = heapq.heappop(minheap)

            if cost < freq[row][col]:
                continue

            for x,y in directions:
                nr, nc = row + x, col + y
                if nr < 0 or nc < 0 or nr > len(grid) - 1 or nc > len(grid[0]) - 1:
                    continue
                if cost + grid[nr][nc] < freq[nr][nc]:
                    freq[nr][nc] = cost + grid[nr][nc]
                    heapq.heappush(minheap, (freq[nr][nc],nr,nc))


        return freq[len(grid)-1][len(grid[0])-1]
            


