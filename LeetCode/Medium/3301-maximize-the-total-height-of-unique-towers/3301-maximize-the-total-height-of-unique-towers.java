class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);

        int structured = maximumHeight[n - 1];
        int sum = structured;
        for (int i = n - 2; i >= 0; i--) {
            if (structured <= maximumHeight[i]) {
                structured--;
            } else {
                structured = maximumHeight[i];
            }
            if (structured <= 0) {
                return -1;
            }
            sum += structured;
        }
        return sum;
    }
}