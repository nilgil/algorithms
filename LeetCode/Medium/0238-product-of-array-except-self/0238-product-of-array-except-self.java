class Solution {
    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                all *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                nums[i] = 0;
            } else if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = all;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = all / nums[i];
            }
        }
        return nums;
    }
}