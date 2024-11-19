class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer wait = map.get(nums[i]);
            if (wait != null && wait < 0) {
                return new int[]{i, (wait + 1) * -1};
            }
            map.put(nums[i], i + 1);
            int key = target - nums[i];
            map.put(key, (i + 1) * -1);
        }
        return null;
    }
}