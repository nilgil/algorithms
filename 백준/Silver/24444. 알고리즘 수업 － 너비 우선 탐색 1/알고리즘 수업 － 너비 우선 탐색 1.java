import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int n, m, r;
	static List<Integer>[] graph;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		input();
		bfs(r);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		visited[start] = ++count;
		queue.offer(start);
		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			for (Integer other : graph[now]) {
				if (visited[other] == 0) {
					visited[other] = ++count;
					queue.offer(other);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new int[n + 1];

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		for (int i = 1; i <= n; i++) {
			graph[i].sort(Integer::compareTo);
		}
	}
}
