import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int pickCount = nums.length / 2;
        Set<Integer> kindCount = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());

        return Math.min(pickCount, kindCount.size());
    }
}