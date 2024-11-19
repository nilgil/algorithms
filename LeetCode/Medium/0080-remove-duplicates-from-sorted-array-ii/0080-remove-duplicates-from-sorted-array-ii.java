class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int k = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[k] < nums[i]) {
                nums[k+2] = nums[i];
                k++;
            }
        }
        return k+2;
    }
}