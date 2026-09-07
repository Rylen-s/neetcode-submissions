class Solution {
    public int findDuplicate(int[] nums) {
        for(int n : nums) {
            if(nums[Math.abs(n)] > 0) {
                nums[Math.abs(n)] *= -1;
            }
            else{
                return Math.abs(n);
            }
        }
        return 1;
    }
}
