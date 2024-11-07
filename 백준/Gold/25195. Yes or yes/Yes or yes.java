import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * */
public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] fans;
	static boolean canAvoid;

	private static void dfs(int node) {
		if (canAvoid || fans[node]) {
			return;
		}
		List<Integer> adjNodes = graph.get(node);
		if (adjNodes.isEmpty()) {
			canAvoid = true;
			return;
		}
		for (Integer nextNode : adjNodes) {
			dfs(nextNode);
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		dfs(1);
		System.out.println(canAvoid ? "yes" : "Yes");
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		fans = new boolean[n + 1];

		int m = Integer.parseInt(st.nextToken());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
		}

		int s = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (s-- > 0) {
			fans[Integer.parseInt(st.nextToken())] = true;
		}
	}
}
