import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Queue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
		while (n-- > 0) {
			heights.offer(Integer.parseInt(br.readLine()));
		}

		int count = 0;
		while (t-- > 0) {
			Integer height = heights.poll();
			if (height == 1 || height < h) {
				heights.offer(height);
				break;
			}
			heights.offer(height / 2);
			count++;
		}

		Integer height = heights.poll();
		if (height < h) {
			System.out.println("YES");
			System.out.println(count);
			return;
		}
		System.out.println("NO");
		System.out.println(height);
	}
}
