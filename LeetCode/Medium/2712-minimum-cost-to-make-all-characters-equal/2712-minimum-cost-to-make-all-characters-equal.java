class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        long cost = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                cost += Math.min(i, n - i);
            }
        }
        return cost;
    }
}