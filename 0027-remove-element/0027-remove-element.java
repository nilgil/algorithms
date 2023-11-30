class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        int p2 = nums.length - 1;
        
        while(p1 <= p2) {
            
            if (nums[p1] == val) {
                
                while(p1 < p2 && nums[p2] == val) {
                    p2--;
                }
                
                if (p1 != p2) {
                    nums[p1] = nums[p2];
                    p2--;
                } else {
                    return p1;
                }
                
            }
            p1++;
        }
        return p1;
    }
}