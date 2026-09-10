class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        for(int res : nums){
            val ^= res;
        }
        return val;
    }
}
