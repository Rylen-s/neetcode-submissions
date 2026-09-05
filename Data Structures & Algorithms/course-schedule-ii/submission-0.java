class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Figure out prereqs
        // Attach non required ones
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] c : prerequisites) {
            adj.get(c[0]).add(c[1]);
            inDegree[c[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses;i++) {
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int total = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()) {
            int temp = q.poll();
            res[numCourses - total - 1] = temp;
            total++;
                for(int neighbor : adj.get(temp)) {
                    if(--inDegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
        }

        return total == numCourses ? res : new int[0];

    }
}
