class Solution {
    public Map<Character, String> map = new HashMap<>(Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"));
    public List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        StringBuilder word;
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    public void dfs(String digits, int i, StringBuilder string) {
        if(string.length() == digits.length()) {
            res.add(string.toString());
            return;
        }

        for(char c : map.get(digits.charAt(i)).toCharArray()) {
            string.append(c);
            dfs(digits, i+1, string);
            string.setLength(string.length() - 1);
        }

    }
}
