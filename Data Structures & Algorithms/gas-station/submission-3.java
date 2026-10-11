class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gass = Arrays.stream(gas).sum();
        int drives = Arrays.stream(cost).sum();
        int tot = 0;
        int index = 0;

        if(gass < drives) return -1;
        
        for(int i = 0 ; i < gas.length; i++) {
            tot += gas[i] - cost[i];
            if(tot < 0){
                tot = 0;
                index = i+1;
            }
        }
        return index;
    }
}
