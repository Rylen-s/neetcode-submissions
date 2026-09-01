class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Dijkstras
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        // HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> heap = new LinkedList<>();
        for(int[] time : times) {
            if(adj[time[0]] == null) adj[time[0]] = new ArrayList<>();
            adj[time[0]].add(new int[]{time[1],time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(k, 0);
        heap.offer(new int[]{k, 0});
        int total = 0;
        int count = 0;
        while(!heap.isEmpty()) {
            int[] temp = heap.poll();
            if (dist.get(temp[0]) < temp[1] || adj[temp[0]] == null) {
                continue;
            }
            // int min = Integer.MAX_VALUE, where = -1;
            for(int i = 0; i < adj[temp[0]].size(); i++) {
                if(adj[temp[0]].get(i)[1] + temp[1] < dist.get(adj[temp[0]].get(i)[0])) {
                    dist.put(adj[temp[0]].get(i)[0], adj[temp[0]].get(i)[1] + temp[1]);
                    heap.offer(new int[]{adj[temp[0]].get(i)[0],adj[temp[0]].get(i)[1]+temp[1]});
                }
            }
        }
        int res = Collections.max(dist.values());
        return res != Integer.MAX_VALUE? res : -1;
    }
}
