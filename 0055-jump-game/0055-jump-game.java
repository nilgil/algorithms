class Solution {
    public boolean canJump(int[] nums) {
        int distance = 1;
        for(int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
        }
        return distance == 1;
    }
}