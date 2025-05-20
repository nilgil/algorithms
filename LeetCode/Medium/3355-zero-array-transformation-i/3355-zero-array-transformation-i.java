class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int[] dp = new int[100001];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            dp[l]--;
            dp[r + 1]++;
        }

        for (int i = 1; i < nums.length; i++) {
            dp[i] += dp[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + dp[i] > 0) {
                return false;
            }
        }

        return true;
    }
}