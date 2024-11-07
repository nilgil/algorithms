import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, s;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] fans;
	static boolean[] visited;
	static boolean mustMeet = true;

	public static void main(String[] args) throws Exception {
		input();

		dfs(1);

		System.out.println(mustMeet ? "Yes" : "yes");
	}

	private static void dfs(int node) {
		if (!mustMeet || fans[node]) {
			return;
		}
		List<Integer> nearNodes = graph.get(node);
		if (nearNodes.isEmpty()) {
			mustMeet = false;
		}
		for (Integer next : nearNodes) {
			if (!visited[next]) {
				visited[node] = true;
				dfs(next);
				visited[node] = false;
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		fans = new boolean[n + 1];
		visited = new boolean[n + 1];
		m = Integer.parseInt(st.nextToken());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
		}
		s = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (s-- > 0) {
			fans[Integer.parseInt(st.nextToken())] = true;
		}
	}
}
