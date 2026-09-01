class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adj = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        for(String word : words){
            for(char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int word = 1; word < words.length; word++) {
            String word1 = words[word-1];
            String word2 = words[word];
            int minlen = Math.min(word1.length(), word2.length());
            if(word1.length() > word2.length() && word1.substring(0,minlen).equals(word2.substring(0,minlen))) {
                return "";
            }
            for(int j = 0; j < minlen; j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    if(!adj.get(word1.charAt(j)).contains(word2.charAt(j))) {
                        adj.get(word1.charAt(j)).add(word2.charAt(j));
                        inDegree[word2.charAt(j) - 'a']++; 
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) {
                q.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            for(char next : adj.get(c)) {
                if(--inDegree[next-'a'] == 0) {
                    q.offer(next);
                }
            }
        }
        int count = 0;
        for(int i : inDegree) {
            if(i != -1) count++;
        }
        if(count != result.length()) return "";

        return result.toString();
    }
}
