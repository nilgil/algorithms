class Solution {

    public int searchInsert(int[] nums, int target) {
        return test(nums, target, 0, nums.length - 1);
    }

    private int test(int[] nums, int target, int start, int end) {
        int centerIdx = (start + end) / 2;
        int centerValue = nums[centerIdx];
        if (start > end) {
            return start;
        }
        if (target < centerValue) {
            return test(nums, target, start, centerIdx - 1);
        }
        if (centerValue < target) {
            return test(nums, target, centerIdx + 1, end);
        }
        return centerIdx;
    }
}