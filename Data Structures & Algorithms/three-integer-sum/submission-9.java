class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if(nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                }
                else if(nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                }
                else {
                    res.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                
                while(l < r && nums[l] == nums[l-1]) l++;
                while(l < r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return res;
    }
}
