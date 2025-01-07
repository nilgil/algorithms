import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] {a, 0});
		while (!queue.isEmpty()) {
			long[] poll = queue.poll();
			if (poll[0] == b) {
				System.out.println(poll[1] + 1);
				return;
			} else if (poll[0] < b) {
				queue.offer(new long[] {poll[0] * 2, poll[1] + 1});
				queue.offer(new long[] {poll[0] * 10 + 1, poll[1] + 1});
			}
		}
		System.out.println(-1);
	}
}
