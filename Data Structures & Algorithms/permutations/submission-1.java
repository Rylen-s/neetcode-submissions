class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        for(int num : nums) {
            dfs(nums, new ArrayList<>(List.of(num)));
        }
        return res;
    }

    public void dfs(int nums[], List<Integer> list) {
        // System.out.println(list);
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int num : nums) {
            if(list.contains(num))
                continue;
            list.add(num);
            dfs(nums, list);
            list.remove(list.size()-1);
        }
    }
}
