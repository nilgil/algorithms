import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		parents = new int[n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st;
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
	}

	static int n;
	static List<Integer>[] graph;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();

		dfs(1);

		for (int i = 2; i <= n; i++) {
			sb.append(parents[i]).append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int node) {
		for (int child : graph[node]) {
			if (!visited[child]) {
				parents[child] = node;
				visited[child] = true;
				dfs(child);
				visited[child] = false;
			}
		}
	}
}
