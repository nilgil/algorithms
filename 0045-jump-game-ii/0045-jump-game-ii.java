class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int bound = 0;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == bound) { // 
                count++;
                bound = max;
            } 
        }
        return count;
    }
}