class Solution {
    public long solution(int n, int[] times) {
		long l = 0;
		long r = (long)1e18;

		while (l <= r) {
			long m = (l + r) / 2;
			long count = 0;
			for (int time : times) {
				count += m / time;
			}
			if (count < n) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
	}
}