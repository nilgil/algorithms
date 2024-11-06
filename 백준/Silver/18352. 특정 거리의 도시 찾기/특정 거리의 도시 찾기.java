import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int INF = 1_000_000_000;

	static int n, m, k, x;
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] costs;

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		input();

		dijkstra(x);

		boolean match = false;
		for (int i = 1; i <= n; i++) {
			if (costs[i] == k) {
				match = true;
				sb.append(i).append('\n');
			}
		}
		System.out.println(!match ? -1 : sb);
	}

	private static void dijkstra(int start) {
		costs[start] = 0;
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (visited[now.index]) {
				continue;
			}
			visited[now.index] = true;
			for (Node next : graph[now.index]) {
				int newCost = costs[now.index] + next.cost;
				if (newCost < costs[next.index]) {
					costs[next.index] = newCost;
					queue.offer(new Node(next.index, newCost));
				}
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		costs = new int[n + 1];
		Arrays.fill(costs, INF);

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, 1));
		}
	}
}
