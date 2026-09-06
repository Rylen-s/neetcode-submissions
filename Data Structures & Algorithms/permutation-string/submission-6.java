class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        HashMap<Character, Integer> count = new HashMap<>();
        int needs = s1.length();
        for(char c : s1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s1.length(); i++) {
            if(count.containsKey(s2.charAt(i))) {
                count.put(s2.charAt(i), count.get(s2.charAt(i)) - 1);
                if(count.get(s2.charAt(i)) >= 0)
                    needs--;
            }
        }
        if(needs == 0) return true;

        for(int r = s1.length(), l = 0; r < s2.length(); r++, l++) {
            
            if(count.containsKey(s2.charAt(r))) {
                if(count.get(s2.charAt(r)) > 0)
                    needs--;
                count.put(s2.charAt(r), count.get(s2.charAt(r)) - 1); 
            }

            if(count.containsKey(s2.charAt(l))) {
                if(count.get(s2.charAt(l)) >= 0)
                    needs++;
                count.put(s2.charAt(l), count.get(s2.charAt(l)) + 1);
            }
            if(needs == 0) return true;
            
        }
        return false;
    }
}
