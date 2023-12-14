class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            Integer res = map.get(target - nums[i]);
            if (res != null && res != i) {
                return new int[]{i, res};
            }
        }
        return null;
    }
}