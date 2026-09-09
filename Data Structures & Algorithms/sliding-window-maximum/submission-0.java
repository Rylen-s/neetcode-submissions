class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int[] res = new int[nums.length-k+1];

        for(int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }

        for(int i = k - 1; i < nums.length;i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while(maxHeap.peek()[1] < i - k + 1)
                maxHeap.poll();
            res[i - k + 1] = maxHeap.peek()[0];
            
        }

    return res;
    }
}
