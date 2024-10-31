import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int n, m, r, count = 1;
	static int[] order;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws Exception {
		input();

		for (List<Integer> connects : graph) {
			connects.sort(Integer::compareTo);
		}

		dfs(r);

		for (int i = 1; i <= n; i++) {
			sb.append(order[i]).append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int node) {
		order[node] = count++;
		for (int i = 0; i < graph.get(node).size(); i++) {
			Integer next = graph.get(node).get(i);
			if (order[next] == 0) {
				dfs(next);
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		order = new int[n + 1];

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
	}
}
