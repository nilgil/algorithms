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

	static final int INF = 1_000_000_000;

	static int n, d;
	static List<List<Node>> graph;
	static int[] costs;

	public static void main(String[] args) throws Exception {
		input();

		dijkstra(0);

		System.out.println(costs[d]);
	}

	private static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			int nextIndex = now.index + 1;
			int nextWeight = now.weight + 1;
			if (nextIndex <= d && nextWeight < costs[nextIndex]) {
				costs[nextIndex] = nextWeight;
				queue.offer(new Node(nextIndex, nextWeight));
			}

			for (Node shortcut : graph.get(now.index)) {
				int destIndex = shortcut.index;
				int destWeight = now.weight + shortcut.weight;
				if (destWeight < costs[destIndex]) {
					costs[destIndex] = destWeight;
					queue.offer(new Node(destIndex, destWeight));
				}
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= d; i++) {
			graph.add(new ArrayList<>());
		}

		costs = new int[d + 1];
		Arrays.fill(costs, INF);
		costs[0] = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (v <= d) {
				graph.get(u).add(new Node(v, w));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int index;
		int weight;

		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.index, o.index);
		}
	}
}
