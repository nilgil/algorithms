import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m, a, b, result = -1;
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		dfs(a, 0);
		System.out.println(result);
	}

	private static void dfs(int num, int depth) {
		if (num == b) {
			result = depth;
			return;
		}
		List<Integer> child = graph[num];
		for (Integer next : child) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, depth + 1);
				visited[next] = false;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
			graph[child].add(parent);
		}
	}
}
