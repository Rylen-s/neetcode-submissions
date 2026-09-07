class Solution {
    public int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        minheap.add(new int[]{0,0,grid[0][0]});

        int max = 0;

        while(!minheap.isEmpty()) {
            int[] temp = minheap.poll();
            max = Math.max(max, grid[temp[0]][temp[1]]);
            if(temp[0] == grid.length - 1 && temp[0] == temp[1]) break;
            
            visited[temp[0]][temp[1]] = true;
            for(int[] dir : directions) {
                int x = temp[0] + dir[0];
                int y = temp[1] + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid.length && !visited[temp[0] + dir[0]][temp[1] + dir[1]]) {
                    minheap.offer(new int[]{temp[0] + dir[0], temp[1] + dir[1], grid[temp[0] + dir[0]][temp[1] + dir[1]]});
                }
            }
        }
        return max;
    }
}
