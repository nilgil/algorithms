import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dsCount = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 2; i <= n; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			if (dsCount <= now) {
				queue.offer(now - 1);
				dsCount++;
				result++;
			}
		}
		System.out.println(result);
	}
}
