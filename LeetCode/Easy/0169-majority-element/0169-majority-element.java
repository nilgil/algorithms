class Solution {
    public int majorityElement(int[] nums) {
        int winner = 0;
        int votes = 0;
        for (int candidate : nums) {
            if (votes == 0) {
                winner = candidate;
            }
            if (winner == candidate) {
                votes++;
            } else {
                votes--;
            }
        }
        return winner;
    }
}