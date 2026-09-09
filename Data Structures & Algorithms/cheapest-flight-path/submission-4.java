class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[2], flight[1]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});

        while(!q.isEmpty()) {
            var tmp = q.poll();
            int cost = tmp[0], curr = tmp[1];
            if(tmp[2] > k)
                continue;
            for(var neighbor : adj[curr]) {
                if(neighbor[0] + cost < prices[neighbor[1]]) {
                    prices[neighbor[1]] = neighbor[0] + cost;
                    q.offer(new int[]{neighbor[0] + cost, neighbor[1], tmp[2] + 1});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

    }
}
