class Solution {
    public int titleToNumber(String columnTitle) {
		int n = columnTitle.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			char c = columnTitle.charAt(n - i - 1);
			int i1 = c - 'A' + 1;
			sum += (int)(Math.pow(26, i) * i1);
		}
		return sum;
	}
}