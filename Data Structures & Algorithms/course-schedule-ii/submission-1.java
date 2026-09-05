class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Figure out prereqs
        // Attach non required ones
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int[] c : prerequisites) {
            adj.putIfAbsent(c[1], new ArrayList<>());
            adj.get(c[1]).add(c[0]);
            inDegree[c[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses;i++) {
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int temp = q.poll();
            res.add(temp);
            if(adj.get(temp) != null) {
                for(int neighbor : adj.get(temp)) {
                    if(--inDegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        for(int in : inDegree) {
            if(in > 0)
                return new int[0];
        }

        for(int i = 0; i < numCourses; i++) {
            if(!res.contains(i)) res.add(i);
        }

        return res.size() == numCourses ? res.stream()
                                   .mapToInt(Integer::intValue)
                                   .toArray() : new int[0];

    }
}
