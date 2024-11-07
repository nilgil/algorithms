import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, maxDist;
	static Queue<Integer> negatives = new PriorityQueue<>(Collections.reverseOrder());
	static Queue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		input();
		initMaxDist();

		int walkCount = 0;
		while (!positives.isEmpty()) {
			walkCount += positives.poll() * 2;
			for (int i = 0; i < m - 1; i++) {
				positives.poll();
			}
		}
		while (!negatives.isEmpty()) {
			walkCount += negatives.poll() * 2;
			for (int i = 0; i < m - 1; i++) {
				negatives.poll();
			}
		}
		System.out.println(walkCount - maxDist);
	}

	private static void initMaxDist() {
		if (positives.isEmpty()) {
			maxDist = negatives.peek();
		} else if (negatives.isEmpty()) {
			maxDist = positives.peek();
		} else {
			maxDist = Math.max(positives.peek(), negatives.peek());
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			int index = Integer.parseInt(st.nextToken());
			if (index < 0) {
				negatives.offer(Math.abs(index));
			} else {
				positives.offer(index);
			}
		}
	}
}
