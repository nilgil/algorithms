import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int sum = 0;
			while (e-- > 0) {
				sum += Integer.parseInt(st.nextToken());
			}
			queue.offer(sum);
		}
		int sum = 0;
		int result = 0;
		while (!queue.isEmpty()) {
			sum += queue.poll();
			result += sum;
		}
		System.out.println(result);
	}
}
