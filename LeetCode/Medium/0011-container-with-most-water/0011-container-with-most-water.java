class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxArea = 0;

        while (l < r) {
            int leftHeight = height[l];
            int rightHeight = height[r];
            int lowHeight = Math.min(leftHeight, rightHeight);
            int area = lowHeight * (r - l);
            maxArea = Math.max(maxArea, area);

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}