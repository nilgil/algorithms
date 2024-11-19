class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int count = 0;

        if (n < m) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            char c1 = haystack.charAt(i);
            char c2 = needle.charAt(count);
            if (c1 == c2) {
                count++;
            } else {
                i = i - count;
                count = 0;
            }
            if (count == m) {
                return i - count + 1;
            }
        }
        return -1;
    }
}