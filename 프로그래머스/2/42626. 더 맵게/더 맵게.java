import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
		Queue<Integer> queue = Arrays.stream(scoville)
			.boxed()
			.collect(Collectors.toCollection(PriorityQueue::new));
		int answer = 0;
		while (queue.peek() < K) {
			if (queue.size() < 2) {
				return -1;
			}
			queue.offer(queue.poll() + queue.poll() * 2);
			answer++;
		}
		return answer;
	}
}