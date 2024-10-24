import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int f, s, g, u, d;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		bfs(s);
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(new int[] {start, 0});
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int idx = poll[0];
			int count = poll[1];

			if (idx == g) {
				System.out.println(count);
				return;
			}

			int nextUp = idx + u;
			if (nextUp <= f && !visited[nextUp]) {
				visited[nextUp] = true;
				queue.offer(new int[] {nextUp, count + 1});
			}

			int nextDown = idx - d;
			if (1 <= nextDown && !visited[nextDown]) {
				visited[nextDown] = true;
				queue.offer(new int[] {nextDown, count + 1});
			}
		}
		System.out.println("use the stairs");
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visited = new boolean[f + 1];
	}
}
